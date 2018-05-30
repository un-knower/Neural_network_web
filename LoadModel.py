import tensorflow as tf
import time
import sys
import os


def inputs():
    # 定义输入输出placeholder。
    x = tf.placeholder(tf.float32, [None, 13], name='x-input')
    return x


InputVector = 13
Layer1Vector = 40
OutPutVector = 8


def inference(input_tensor):
    with tf.variable_scope('layer1'):  # ,reuse=True
        weights = tf.get_variable("weights", [InputVector, Layer1Vector],
                                  initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [Layer1Vector], initializer=tf.constant_initializer(0.0))
        layer1 = tf.nn.relu(tf.matmul(input_tensor, weights) + biases)

    with tf.variable_scope('layer2'):  # ,reuse=True
        weights = tf.get_variable("weights", [Layer1Vector, OutPutVector],
                                  initializer=tf.truncated_normal_initializer(stddev=0.1))
        biases = tf.get_variable("biases", [OutPutVector], initializer=tf.constant_initializer(0.0))
        layer2 = tf.matmul(layer1, weights) + biases

    return layer2


def loss(y_pred, y_real):
    # 定义损失函数, 这里使用softmax_cross_entropy_with_logits, 首先在对inference输出添加一个
    # softmax层归一化概率，然后计算inference的误差
    cross_entropy = tf.nn.softmax_cross_entropy_with_logits(logits=y_pred, labels=y_real)
    loss = tf.reduce_mean(cross_entropy)
    return loss


def accuracy(y_pred, y_real):
    correct_prediction = tf.equal(tf.argmax(y_pred, 1), tf.argmax(y_real, 1))
    acc = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))
    return acc


def train_optimizer(loss):
    train_step = tf.train.GradientDescentOptimizer(learning_rate = 0.001).minimize(loss)
    return train_step

def loadModel(sess,inputdata):
    x = inputs()
    y = inference(x)
    sess.run(tf.global_variables_initializer())
    saver=tf.train.Saver()
    os.getcwd()
    load_path=saver.restore(sess,"/data/lyh/container_data/soft/apache-tomcat-7.0.85/webapps/resoures/model/model.ckpt")
    prediction=sess.run(y,feed_dict={x:inputdata})
    #print(prediction)
    return prediction.argmax()
    #mode_file=tf.train.latest_checkpoint('./txcard/model/')
    #val_loss,val_acc=sess.run([loss,acc],feed_dict={x:,y:})
    #print('val_loss:%f, val_acc:%f'%(val_loss,val_acc))

#print("start:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
#print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
inputStr=sys.argv[1]
arry= inputStr.split(',')
inputa=[arry[6:]]

app_map={0:'C1107',1:'C223897',2:'C225569',3:'C370',4:'C688',5:'C700',6:'C729',7:'C946'}
sess = tf.InteractiveSession()
#print ("start:------------------")
appID=app_map[loadModel(sess,inputa)]
print(appID)
sess.close()
#print("end:",time.strftime('%Y-%m-%d %H:%M:%S',time.localtime(time.time())))
#print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")
