
# coding: utf-8

# In[2]:


from sklearn import preprocessing
from sklearn.feature_extraction import DictVectorizer

def one_hot_dataframe(data, cols, replace=False):
    """ Takes a dataframe and a list of columns that need to be encoded.
        Returns a 3-tuple comprising the data, the vectorized data,
        and the fitted vectorizor.
    """
    vec = DictVectorizer()
    mkdict = lambda row: dict((col, row[col]) for col in cols)
    # manuplate the column
    #print type(data[cols])
    vecData = pd.DataFrame(vec.fit_transform(data[cols].apply(mkdict,axis=1)).toarray())
    # get column names
    vecData.columns = vec.get_feature_names()
    vecData.index = data.index
    if replace is True:
        data = data.drop(cols, axis=1)
        #column join based on index
        data = data.join(vecData)
    return (data, vecData, vec)


# In[ ]:


import pandas as pd
import time

def preProcessing():
    print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    
    data_header=['userID','appID','appName','appflux','appduration','pv','gender','age','terminal','package','fee','monthflux','occupation','star','payway','nettime']
    
    data = pd.read_table('./txcard/data/data_1.txt',sep='|',names=data_header,engine='python')
    
    #print set(data['terminal'])
    #data.head()
    
    #终端偏好，转换成0-17的数字。
    #print len(set(data['terminal']))
    #ter_map = {x:inx for inx,x in enumerate(set(data['terminal']))}
    #data['terminal']=data['terminal'].map(ter_map)
    
    '''
    %matplotlib inline
    import matplotlib.pyplot as plot
    
    plot.scatter(data['userID'],data['fee'])
    plot.xlabel("user")
    plot.ylabel("fee")
    plot.show()
    #print set(data['terminal'])
    
    
    #print set(data['age']) 
    print "Processing Column Age :========================================="
    data['age'] = [str(float(i)/10).split('.')[0] for i in data['age']]
    data['age'] = data['age'].replace('nan',0)
    
    print("age classifer count:",len(set(data['age'])))
    print set(data['age'])
    '''
    
    
    #data.describe()
    import numpy as np
    
    print "Processing Age/fee/monthflux NaN issue:================"
    #data['age'] = [str(float(i)/10).split('.')[0] for i in data['age']]
    data['age'] = data['age'].replace(np.NaN,0)
    
    #print("age classifer count:",len(set(data['age'])))
    #print set(data['age'])
    
    #data['fee'] = [str(float(i)/20+1).split('.')[0] for i in   data['fee']]
    data['fee'] = data['fee'].replace(np.NaN,0)
    #print("fee classifer count:",len(set(data['fee'])))
    #print set(data['fee'])
    
    #data['monthflux'] = [str(float(i)/100+1).split('.')[0] for i in   data['monthflux']]
    data['monthflux'] = data['monthflux'].replace(np.NaN,0)
    #print("monthflux classifer count:",len(set(data['monthflux'])))
    #print set(data['monthflux'])
    
    print "Processing Column Star/Payway/Nettime :========================================="
    data['star'] = data['star'].replace(np.NaN,0)
    data['gender'] = data['gender'].replace(np.NaN,0)
    #print set(data['star'])
    
    data['payway'] = data['payway'].replace(np.NaN,0)
    print set(data['payway'])
    
    data['nettime'] = data['nettime'].replace(np.NaN,'0-0')
    data['nettime'] = [i.split('-')[1] for i in   data['nettime']]
    print set(data['nettime'])
    
    ter_map = {x:inx for inx,x in enumerate(set(data['terminal']))}
    data['terminal']=data['terminal'].map(ter_map)
    
    
    age=data['age']/10
    age = age.apply(numpy.round)
    data['age']=age   
    
    fee=data['fee']
    #fee = fee.apply(numpy.round)
    #X['fee']=fee
    fee_proce = []
    for i in fee.index:
        if(fee[i]<0):
            fee_proce.append(0)
        elif(fee[i] >=0 and fee[i]<100):
            fee_proce.append(1)
        elif(fee[i] >=100 and fee[i]<200):
            fee_proce.append(2)
        elif(fee[i] >=200 and fee[i]<300):
            fee_proce.append(3)
        elif(fee[i]>=300 and fee[i]<400):
            fee_proce.append(4)
        elif(fee[i]>=400 and fee[i] <600):
            fee_proce.append(5)
        elif(fee[i] >=600 and fee[i]<1200):
            fee_proce.append(7)
        elif(fee[i] >=1200 and fee[i]<=2400):
            fee_proce.append(7)
        elif(fee[i]>2400):
            fee_proce.append(8)
    data['fee']=fee_proce
    
    
    
    flux_proce=[]
    flux=data['monthflux']#/100
    #flux = flux.apply(numpy.round)
    #X['monthflux']=flux

    for i in flux.index:
        if(flux[i]<=200000):
            flux_proce.append(numpy.round(flux[i]/10000))
            #flux_proce.append(1)
        elif(flux[i] >200000 and flux[i]<=300000):
            flux_proce.append(21)
        elif(flux[i] >300000 and flux[i]<=400000):
            flux_proce.append(22)
        elif(flux[i] >400000 and flux[i]<=500000):
            flux_proce.append(23)
        elif(flux[i] >500000 and flux[i]<=600000):
            flux_proce.append(24)
        elif(flux[i] >600000 and flux[i]<=800000):
            flux_proce.append(25)
        elif(flux[i] >800000 ):
            flux_proce.append(26)
        #    '''
    data['monthflux']=flux_proce
    
    print "Processing Column Occupation :========================================="
    
    df_out,vecData,vec = one_hot_dataframe(data,['occupation'],replace=True)  
    #print set(df_out['occupation'])
    df_out.drop('occupation',axis=1, inplace=True)
    df_out = df_out.rename(columns={'occupation=IT人员':'occ_IT','occupation=医疗工作者':'occ_med','occupation=教育工作者':'occ_tea','occupation=金融行业':'occ_fina'})
    
    
    df_out.head()
    
    target_frame=df_out[['userID','appID','appduration']]
    df_out=df_out.sort_values(by=['userID','appduration'])
    df_out = df_out.drop_duplicates(['userID'],keep='first')
    df_out.to_csv('./txcard/data/datacoll_1.csv',index=False)
    
    print("end:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
    


#preProcessing()


# # 查看数据分布

# In[1]:


import pandas as pd
import time
#data_header=['userID','appID','appName','appflux','appduration','pv','gender','age','terminal','package','fee','monthflux','occupation','star','payway','nettime']
#字段名称：userID,appID,appName,appflux,appduration,pv,gender,age,terminal,package,fee,monthflux,star,payway,nettime,occ_IT,occ_med,occ_tea,occ_fina
print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
data = pd.read_table('./txcard/data/datacoll.csv',sep=',',engine='python')
#for i in data.columns.values:
#    print ("column name :",i)
#    for k in set(data[i]):
#        print("value name: %s, count of examaples: %d",len(data[data[i]==k]))
data=data[['appID','gender','age','terminal','package','fee','monthflux','star','payway','nettime']]

print data.columns.values
#for i in data.columns.values:
#    print "column name :",i
#    print "===============",len(set(data[i])),"==============="
#    print set(data[i])
#    for k in set(data[i]): 
#        print len(data[data[i]==k])
print "-----appID"
for k in set(data['appID']):         
    print k,",",len(data[data['appID']==k])

print "-----gender"
for k in set(data['gender']):         
    print k,",",len(data[data['gender']==k])
    
print "-----age"
for k in set(data['age']):         
    print k,",",len(data[data['age']==k])

print "-----terminal"
for k in set(data['terminal']):         
    print k,",",len(data[data['terminal']==k])

print "-----package"
for k in set(data['package']):         
    print k,",",len(data[data['package']==k])

print "-----star"
for k in set(data['star']):         
    print k,",",len(data[data['star']==k])

print "-----payway"
for k in set(data['payway']):         
    print k,",",len(data[data['payway']==k])

print "-----nettime"
for k in set(data['nettime']):         
    print k,",",len(data[data['nettime']==k])
    
print("end:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")


# # fee和flux都保留原值/分类值，尝试训练

# In[ ]:


import pandas as pd
import time

def inputs():
    # 定义输入输出placeholder。
    x = tf.placeholder(tf.float32, [None, 13], name='x-input')
    y_ = tf.placeholder(tf.float32, [None, 8], name='y-input')
    return x, y_

InputVector=13
Layer1Vector=40
OutPutVector=8

def inference(input_tensor):
    with tf.variable_scope('layer1',reuse=True):#,reuse=True
        weights = tf.get_variable("weights", [InputVector, Layer1Vector], initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [Layer1Vector], initializer=tf.constant_initializer(0.0))
        layer1 = tf.nn.relu(tf.matmul(input_tensor, weights) + biases)


    with tf.variable_scope('layer2',reuse=True):#,reuse=True
        weights = tf.get_variable("weights", [Layer1Vector, OutPutVector], initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [OutPutVector], initializer=tf.constant_initializer(0.0))
        layer2 = tf.matmul(layer1, weights) + biases

    return layer2

def loss(y_pred, y_real):
    # 定义损失函数, 这里使用softmax_cross_entropy_with_logits, 首先在对inference输出添加一个
    # softmax层归一化概率，然后计算inference的误差
    cross_entropy=tf.nn.softmax_cross_entropy_with_logits(logits=y_pred, labels=y_real)
    loss = tf.reduce_mean(cross_entropy)
    return loss
    
def accuracy(y_pred, y_real):
    correct_prediction = tf.equal(tf.argmax(y_pred, 1), tf.argmax(y_real, 1))
    acc= tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    return acc

def train_optimizer(loss):
    train_step = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss)
    return train_step

dataset_size=3012369
batch_size=3000
learning_rate = 0.001
TRAINING_STEPS = 300
    
def train(X,Y):
    x, y_ = inputs()
    y = inference(x)
    losses = loss(y_pred=y, y_real=y_)
    acc = accuracy(y_pred=y, y_real=y_)
    train_step =train_optimizer(loss=losses)
    from sklearn.cross_validation import train_test_split
    X_train,X_test, y_train, y_test = train_test_split(X,Y,test_size=0.8, random_state=0)
    
    
    config = tf.ConfigProto(allow_soft_placement=True)
    config.gpu_options.allocator_type = 'BFC'
    config.gpu_options.per_process_gpu_memory_fraction = 0.80
    saver = tf.train.Saver()  
    
    with tf.Session(config=config) as sess:
        with tf.device("/gpu:0"):
            sess.run(tf.global_variables_initializer())
            for i in range(TRAINING_STEPS):
                start = (i * batch_size) % dataset_size
                end = min(start + batch_size, dataset_size)
                _, loss_value = sess.run([train_step, losses], feed_dict={x: X_train[start:end], y_: y_train[start:end]})
                if i % 50 ==0:
                    print("After %d training step(s), loss on training batch is %g." % (i, loss_value))
                if i % 20 == 0:
                    test_acc = sess.run(acc, feed_dict={x: X_test, y_: y_test})
                    print("After %d training step(s), accuracy on test is %g." % (i, test_acc))
            #test_acc = sess.run(acc, feed_dict={x:mnist.test.images, y_:mnist.test.labels})
            #print("After %d training step(s), accuracy on test is %g." % (TRAINING_STEPS, test_acc))
            saver.save(sess, "./txcard/model/model.ckpt") 

            
#data_header=['userID','appID','appName','appflux','appduration','pv','gender','age','terminal','package','fee','monthflux','occupation','star','payway','nettime']
#字段名称：userID,appID,appName,appflux,appduration,pv,gender,age,terminal,package,fee,monthflux,star,payway,nettime,occ_IT,occ_med,occ_tea,occ_fina
print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

data = pd.read_table('./txcard/data/datacoll_1.csv',sep=',',engine='python')
print data.columns.values
X_C370=data[data['appID']=='C946'].sample(n = 1500000,axis=0)
X_rest=data[data['appID']!='C946']
print "===debug: the length of data X_C370:",len(X_C370)
print "===debug: the length of data X_rest:",len(X_rest)
###exit()

X=X_C370.append(X_rest)
print "debug: the length of data collection:",len(X)

X=data[['gender','age','terminal','package','fee','monthflux','star','payway','nettime','occ_IT','occ_med','occ_tea','occ_fina']]
#X = X.fillna(0)





Y=data[['appID']]
Y_data,vec_data,vec = one_hot_dataframe(Y,['appID'],replace=True) 

print "============================"
print vec.vocabulary_
exit()

#app_map = {x:inx for inx,x in enumerate(set(Y['appflux']))}
#Y['appflux']=Y['appflux'].map(app_map)
print("features and labels are done……")

import tensorflow as tf
#Y_data.head()
train(X,Y_data)
print("end:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")


# # 各种都变成分类的值，再训练(测试，不实际训练了)

# In[28]:


import pandas as pd
import time
import numpy
get_ipython().magic(u'matplotlib inline')
import matplotlib.pyplot as plot

            
#data_header=['userID','appID','appName','appflux','appduration','pv','gender','age','terminal','package','fee','monthflux','occupation','star','payway','nettime']
#字段名称：userID,appID,appName,appflux,appduration,pv,gender,age,terminal,package,fee,monthflux,star,payway,nettime,occ_IT,occ_med,occ_tea,occ_fina
print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

data = pd.read_table('./txcard/data/datacoll.csv',sep=',',engine='python')
print data.columns.values
X_C370=data[data['appID']=='C946'].sample(n = 1500000,axis=0)
X_rest=data[data['appID']!='C946']
#print "===debug: the length of data X_C370:",len(X_C370)
#print "===debug: the length of data X_rest:",len(X_rest)
X=X_C370.append(X_rest)

age=X['age']/10
age = age.apply(numpy.round)
X['age']=age   
'''
fee=X['fee']/20
fee = fee.apply(numpy.round)
#X['fee']=fee
fee_proce = []
for i in fee.index:
    if(fee[i]<0):
        fee_proce.append(0)
    elif(fee[i] >=0 and fee[i]<5):
        fee_proce.append(1)
    elif(fee[i] >=5 and fee[i]<10):
        fee_proce.append(2)
    elif(fee[i] >=10 and fee[i]<15):
        fee_proce.append(3)
    elif(fee[i]>=15 and fee[i]<20):
        fee_proce.append(4)
    elif(fee[i]>=20 and fee[i] <30):
        fee_proce.append(5)
    elif(fee[i] >=30 and fee[i]<60):
        fee_proce.append(7)
    elif(fee[i] >=60 and fee[i]<=120):
        fee_proce.append(7)
    elif(fee[i]>120):
        fee_proce.append(8)
X['fee']=fee_proce



plot.scatter(X['userID'],X['fee'])
plot.xlabel("user")
plot.ylabel("fee")
plot.show()
print "-----fee"
for k in set(X['fee']):         
    print k,",",len(X[X['fee']==k])
'''

flux_proce=[]
flux=X['monthflux']/100
flux = flux.apply(numpy.round)
X['monthflux']=flux

plot.scatter(X['userID'],X['monthflux'])
plot.xlabel("user")
plot.ylabel("monthflux")
plot.show()

for i in flux.index:
    if(flux[i]<=2000):
        flux_proce.append(numpy.round(flux[i]/100))
        #flux_proce.append(1)
    elif(flux[i] >2000 and flux[i]<=3000):
        flux_proce.append(21)
    elif(flux[i] >3000 and flux[i]<=4000):
        flux_proce.append(22)
    elif(flux[i] >4000 and flux[i]<=5000):
        flux_proce.append(23)
    elif(flux[i] >5000 and flux[i]<=6000):
        flux_proce.append(24)
    elif(flux[i] >6000 and flux[i]<=8000):
        flux_proce.append(25)
    elif(flux[i] >8000 ):
        flux_proce.append(26)
    #    '''
X['monthflux']=flux_proce

plot.scatter(X['userID'],X['monthflux'])
plot.xlabel("user")
plot.ylabel("monthflux")
plot.show()
print "-----flux"
for k in set(X['monthflux']):         
    print k,",",len(X[X['monthflux']==k])
    


# In[10]:


def inputs():
    # 定义输入输出placeholder。
    x = tf.placeholder(tf.float32, [None, 13], name='x-input')
    return x

InputVector=13
Layer1Vector=40
OutPutVector=8

def inference(input_tensor):
    with tf.variable_scope('layer1',reuse=True):#,reuse=True
        weights = tf.get_variable("weights", [InputVector, Layer1Vector], initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [Layer1Vector], initializer=tf.constant_initializer(0.0))
        layer1 = tf.nn.relu(tf.matmul(input_tensor, weights) + biases)


    with tf.variable_scope('layer2',reuse=True):#,reuse=True
        weights = tf.get_variable("weights", [Layer1Vector, OutPutVector], initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [OutPutVector], initializer=tf.constant_initializer(0.0))
        layer2 = tf.matmul(layer1, weights) + biases

    return layer2

def loss(y_pred, y_real):
    # 定义损失函数, 这里使用softmax_cross_entropy_with_logits, 首先在对inference输出添加一个
    # softmax层归一化概率，然后计算inference的误差
    cross_entropy=tf.nn.softmax_cross_entropy_with_logits(logits=y_pred, labels=y_real)
    loss = tf.reduce_mean(cross_entropy)
    return loss
    
def accuracy(y_pred, y_real):
    correct_prediction = tf.equal(tf.argmax(y_pred, 1), tf.argmax(y_real, 1))
    acc= tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    return acc

def train_optimizer(loss):
    train_step = tf.train.GradientDescentOptimizer(learning_rate).minimize(loss)
    return train_step


# In[13]:


import tensorflow as tf
import time

def loadModel(sess,inputdata):
    x = inputs()
    y = inference(x)
    sess.run(tf.global_variables_initializer())
    saver=tf.train.Saver()
    load_path=saver.restore(sess,"./txcard/model/model.ckpt")
    prediction=sess.run(y,feed_dict={x:inputdata})
    print prediction
    return prediction.argmax()
    #mode_file=tf.train.latest_checkpoint('./txcard/model/')
    #val_loss,val_acc=sess.run([loss,acc],feed_dict={x:,y:})
    #print('val_loss:%f, val_acc:%f'%(val_loss,val_acc))

print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
inputStr='13001000113,C946,腾讯视频,9166,79.0,6,1.0,6.0,1,4,1,0.0,2.0,0.0,10,0.0,0.0,0.0,0.0'
arry= inputStr.split(',')
inputa=[arry[6:]]

app_map={0:'C1107',1:'C223897',2:'C225569',3:'C370',4:'C688',5:'C700',6:'C729',7:'C946'}
sess = tf.InteractiveSession()
print "start:------------------"
appID=app_map[loadModel(sess,inputa)]
print appID
sess.close()
print("end:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
#######################################################################
# {'appID=C370': 3, 'appID=C946': 7, 'appID=C688': 4, 'appID=C729': 6, 'appID=C700': 5, 'appID=C1107': 0, 'appID=C223897': 1, 'appID=C225569': 2}
#######################################################################

    


# In[ ]:




