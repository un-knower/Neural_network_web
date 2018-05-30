import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.python.google.common.primitives.Bytes;


public class GetUserInfo {
	public static Dictionary<String, String> fileIndex;
	
	public static void fillDic()
	{
//		fileIndex.put("13001000012", "1.txt");
//		fileIndex.put("13126893813", "2.txt");
//		fileIndex.put("13263334038", "3.txt");
//		fileIndex.put("15624984123", "4.txt");
//		fileIndex.put("min", "13001000012");
//		fileIndex.put("max", "15624984364");
		fileIndex.put("13011050301", "3");
		fileIndex.put("15501154021", "61");
		fileIndex.put("18518907297", "191");
		fileIndex.put("13121255728", "20");
		fileIndex.put("17600291625", "92");
		fileIndex.put("18611882868", "241");
		fileIndex.put("13121902634", "23");
		fileIndex.put("13240455777", "40");
		fileIndex.put("13161050440", "32");
		fileIndex.put("17600853030", "104");
		fileIndex.put("18613869902", "254");
		fileIndex.put("18600420868", "204");
		fileIndex.put("17501128366", "85");
		fileIndex.put("15601007829", "70");
		fileIndex.put("18610029292", "218");
		fileIndex.put("18610990778", "229");
		fileIndex.put("18515687882", "183");
		fileIndex.put("18612711209", "250");
		fileIndex.put("17600430964", "95");
		fileIndex.put("13011198994", "4");
		fileIndex.put("13261386691", "48");
		fileIndex.put("18501314164", "152");
		fileIndex.put("18516896081", "185");
		fileIndex.put("18618386151", "259");
		fileIndex.put("18600672765", "207");
		fileIndex.put("17611310280", "133");
		fileIndex.put("13021229206", "7");
		fileIndex.put("13001283655", "2");
		fileIndex.put("18513179979", "171");
		fileIndex.put("18610269370", "221");
		fileIndex.put("18515365208", "181");
		fileIndex.put("17610595766", "119");
		fileIndex.put("18611424868", "235");
		fileIndex.put("13241118800", "41");
		fileIndex.put("17611215652", "131");
		fileIndex.put("18514667780", "178");
		fileIndex.put("17600660919", "100");
		fileIndex.put("18600510004", "205");
		fileIndex.put("18501052909", "150");
		fileIndex.put("17610995601", "127");
		fileIndex.put("17600570771", "98");
		fileIndex.put("18610547357", "224");
		fileIndex.put("13260259363", "45");
		fileIndex.put("18611798386", "240");
		fileIndex.put("17610171280", "113");
		fileIndex.put("18611963459", "242");
		fileIndex.put("18601223857", "214");
		fileIndex.put("17611399235", "135");
		fileIndex.put("17501033828", "84");
		fileIndex.put("17601011880", "107");
		fileIndex.put("18612305367", "246");
		fileIndex.put("13240124152", "39");
		fileIndex.put("13261193780", "47");
		fileIndex.put("13161227405", "33");
		fileIndex.put("15600563697", "68");
		fileIndex.put("18601287311", "215");
		fileIndex.put("18611524327", "236");
		fileIndex.put("18500922130", "149");
		fileIndex.put("15652068203", "79");
		fileIndex.put("17600384211", "94");
		fileIndex.put("17610335210", "116");
		fileIndex.put("13121493653", "21");
		fileIndex.put("13031015766", "8");
		fileIndex.put("13263128822", "51");
		fileIndex.put("17600706730", "101");
		fileIndex.put("15611820830", "77");
		fileIndex.put("13070115104", "15");
		fileIndex.put("18601100405", "212");
		fileIndex.put("18510577679", "158");
		fileIndex.put("18500614082", "147");
		fileIndex.put("15699827363", "83");
		fileIndex.put("18510974361", "161");
		fileIndex.put("18500211552", "143");
		fileIndex.put("17611269887", "132");
		fileIndex.put("13146777172", "31");
		fileIndex.put("15611479297", "75");
		fileIndex.put("13141141020", "27");
		fileIndex.put("17600752653", "102");
		fileIndex.put("18513543103", "174");
		fileIndex.put("15611083579", "73");
		fileIndex.put("13269524778", "56");
		fileIndex.put("max", "18618609999");
		fileIndex.put("18614074341", "255");
		fileIndex.put("18513005333", "169");
		fileIndex.put("13261006175", "46");
		fileIndex.put("18613317369", "253");
		fileIndex.put("17600213075", "90");
		fileIndex.put("18610724027", "226");
		fileIndex.put("15600050360", "66");
		fileIndex.put("17600172844", "89");
		fileIndex.put("17600253258", "91");
		fileIndex.put("18612137947", "244");
		fileIndex.put("17611175195", "130");
		fileIndex.put("13261814830", "50");
		fileIndex.put("17611656991", "140");
		fileIndex.put("15510050001", "62");
		fileIndex.put("18519376664", "195");
		fileIndex.put("18519612615", "196");
		fileIndex.put("18515062796", "179");
		fileIndex.put("18514066812", "177");
		fileIndex.put("18510830742", "160");
		fileIndex.put("18618208169", "257");
		fileIndex.put("13001132011", "1");
		fileIndex.put("18511335481", "164");
		fileIndex.put("18510036571", "154");
		fileIndex.put("13161666269", "35");
		fileIndex.put("13141392641", "28");
		fileIndex.put("13011875322", "5");
		fileIndex.put("17610395786", "117");
		fileIndex.put("17601667153", "110");
		fileIndex.put("17610222596", "114");
		fileIndex.put("15510455174", "64");
		fileIndex.put("15601181071", "71");
		fileIndex.put("18510702544", "159");
		fileIndex.put("18612232361", "245");
		fileIndex.put("18612518082", "248");
		fileIndex.put("13261619893", "49");
		fileIndex.put("17600922129", "105");
		fileIndex.put("17600050183", "86");
		fileIndex.put("17611597600", "139");
		fileIndex.put("18511622551", "166");
		fileIndex.put("13126893813", "26");
		fileIndex.put("17610110930", "112");
		fileIndex.put("17610550688", "118");
		fileIndex.put("13051609187", "13");
		fileIndex.put("18618130966", "256");
		fileIndex.put("18612622396", "249");
		fileIndex.put("15611655335", "76");
		fileIndex.put("18601162500", "213");
		fileIndex.put("13164271742", "37");
		fileIndex.put("13146490161", "30");
		fileIndex.put("17610797273", "123");
		fileIndex.put("18600245800", "202");
		fileIndex.put("17600527911", "97");
		fileIndex.put("13126696786", "25");
		fileIndex.put("18511224443", "163");
		fileIndex.put("13167576121", "38");
		fileIndex.put("17610897897", "125");
		fileIndex.put("18611736567", "239");
		fileIndex.put("18513407009", "173");
		fileIndex.put("18513097259", "170");
		fileIndex.put("17600786031", "103");
		fileIndex.put("17611440112", "136");
		fileIndex.put("18601026787", "211");
		fileIndex.put("15624984123", "78");
		fileIndex.put("13001000012", "0");
		fileIndex.put("17600089184", "87");
		fileIndex.put("13269991992", "58");
		fileIndex.put("13120160305", "17");
		fileIndex.put("18600340222", "203");
		fileIndex.put("18515551656", "182");
		fileIndex.put("13031193399", "9");
		fileIndex.put("13263334038", "52");
		fileIndex.put("15601352756", "72");
		fileIndex.put("15510225982", "63");
		fileIndex.put("18612930787", "252");
		fileIndex.put("18500376595", "145");
		fileIndex.put("18618486679", "260");
		fileIndex.put("18600771704", "208");
		fileIndex.put("17600611899", "99");
		fileIndex.put("18611198381", "232");
		fileIndex.put("18611141960", "231");
		fileIndex.put("17610696006", "121");
		fileIndex.put("18612036189", "243");
		fileIndex.put("15652868322", "82");
		fileIndex.put("17610652230", "120");
		fileIndex.put("13126527600", "24");
		fileIndex.put("18515205153", "180");
		fileIndex.put("18513883937", "176");
		fileIndex.put("13241510739", "42");
		fileIndex.put("18500486589", "146");
		fileIndex.put("18519860509", "198");
		fileIndex.put("18519732078", "197");
		fileIndex.put("18511873968", "168");
		fileIndex.put("13269768608", "57");
		fileIndex.put("13269004807", "54");
		fileIndex.put("17600478801", "96");
		fileIndex.put("18500122985", "142");
		fileIndex.put("17600332515", "93");
		fileIndex.put("18611081478", "230");
		fileIndex.put("18501192580", "151");
		fileIndex.put("18610105801", "219");
		fileIndex.put("18600156906", "201");
		fileIndex.put("18519277623", "194");
		fileIndex.put("18611600423", "237");
		fileIndex.put("17610050623", "111");
		fileIndex.put("18518593513", "189");
		fileIndex.put("18601949066", "217");
		fileIndex.put("min", "13001000012");
		fileIndex.put("13051432768", "12");
		fileIndex.put("17600966381", "106");
		fileIndex.put("13051201189", "11");
		fileIndex.put("18511502166", "165");
		fileIndex.put("15600226632", "67");
		fileIndex.put("18612827875", "251");
		fileIndex.put("13051001082", "10");
		fileIndex.put("14530110104", "60");
		fileIndex.put("18611358680", "234");
		fileIndex.put("18618294399", "258");
		fileIndex.put("18519065858", "192");
		fileIndex.put("17610738398", "122");
		fileIndex.put("14513287906", "59");
		fileIndex.put("18511753595", "167");
		fileIndex.put("18610807626", "227");
		fileIndex.put("17610951289", "126");
		fileIndex.put("18518056402", "186");
		fileIndex.put("15652626527", "81");
		fileIndex.put("18513713849", "175");
		fileIndex.put("13260076873", "44");
		fileIndex.put("17610286175", "115");
		fileIndex.put("15652388120", "80");
		fileIndex.put("18600003558", "199");
		fileIndex.put("13264161555", "53");
		fileIndex.put("13121692387", "22");
		fileIndex.put("17611482517", "137");
		fileIndex.put("15600706765", "69");
		fileIndex.put("17611133064", "129");
		fileIndex.put("17601057988", "108");
		fileIndex.put("18611289721", "233");
		fileIndex.put("18519155551", "193");
		fileIndex.put("18501945186", "153");
		fileIndex.put("18500759991", "148");
		fileIndex.put("18610639627", "225");
		fileIndex.put("13021040034", "6");
		fileIndex.put("15510671130", "65");
		fileIndex.put("18600944241", "210");
		fileIndex.put("13146178818", "29");
		fileIndex.put("18510165342", "155");
		fileIndex.put("17611350290", "134");
		fileIndex.put("18610338585", "222");
		fileIndex.put("18600858712", "209");
		fileIndex.put("13071197015", "16");
		fileIndex.put("18600595014", "206");
		fileIndex.put("18600069101", "200");
		fileIndex.put("17611037565", "128");
		fileIndex.put("13241838500", "43");
		fileIndex.put("15611269555", "74");
		fileIndex.put("18611678491", "238");
		fileIndex.put("18610453338", "223");
		fileIndex.put("13161469188", "34");
		fileIndex.put("18500029399", "141");
		fileIndex.put("13269232966", "55");
		fileIndex.put("13121084393", "19");
		fileIndex.put("17601600310", "109");
		fileIndex.put("18610895217", "228");
		fileIndex.put("13120340399", "18");
		fileIndex.put("18518381888", "188");
		fileIndex.put("17611537630", "138");
		fileIndex.put("18500311869", "144");
		fileIndex.put("18518722285", "190");
		fileIndex.put("18610190585", "220");
		fileIndex.put("18518206731", "187");
		fileIndex.put("18515933970", "184");
		fileIndex.put("18510279313", "156");
		fileIndex.put("13051831517", "14");
		fileIndex.put("18513299954", "172");
		fileIndex.put("18601365199", "216");
		fileIndex.put("17600129525", "88");
		fileIndex.put("18612403606", "247");
		fileIndex.put("18511088275", "162");
		fileIndex.put("17610853086", "124");
		fileIndex.put("18510407515", "157");
		fileIndex.put("13161865989", "36");
	}
	
	public GetUserInfo()
	{
		if(fileIndex == null){
			fileIndex = new Hashtable<String,String>();
			fillDic();
		}
		System.out.println(fileIndex.size());
	}
	
	public String searchNumber(String phonestr,String dirpath) throws IOException{
		
		System.out.println("function public String searchNumber(String phonestr,String dirpath)  " );
		
		String[] errorStr={"not diretory or not exist","directory empty.","file found,String not foud","unknown error"};
		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		try {
				{
					File Log = new File("../../logging.txt");
					if(!Log.exists()){
						Log.createNewFile();
					}
					

					outSTr = new FileOutputStream(Log);
					Buff = new BufferedOutputStream(outSTr);
					long begin0 = System.currentTimeMillis();
					
					
					File dir= new File(dirpath);
					if(!dir.isDirectory() || !dir.exists()){
						return errorStr[0]+" | "+ dirpath;
					}
					Buff.write("dir exitst check\r\n".getBytes());
					Buff.write((dir.getAbsolutePath()+"\r\n").getBytes());
					String[] filelist = dir.list();
					ArrayList<Double> filelistd = new ArrayList<Double>();
					
					if(filelist.length==0){
						return errorStr[1];
					}
					Enumeration<String> ekeys=fileIndex.keys();
					for(int i=0;i<filelist.length;i++){
						String ke=ekeys.nextElement();
						if(ke.equals("max") || ke.equals("min")){
							--i;continue;
						}
						filelistd.add(Double.parseDouble(ke));
					}
				
					Collections.sort(filelistd,new Comparator<Double>() {
						@Override
						public int compare(Double d1,Double d2){
							return d1.compareTo(d2);
						}
					});
					for(int i=0;i<filelistd.size();++i)
					{
						Buff.write((","+filelistd.get(i)).getBytes());
					}
					Buff.write("\r\n".getBytes());
					
					Double phone=Double.parseDouble(phonestr);
					if(phone >Double.parseDouble(fileIndex.get("max")) || phone < Double.parseDouble(fileIndex.get("min"))){
						return errorStr[2];
					}
					int left=0;int right = filelist.length-1;
					int middle =0;
					while(left<=right){
						middle=(left+right)/2;
						Buff.write("left:".getBytes());
						Buff.write((String.valueOf(left)+" ,").getBytes());
						Buff.write("middle:".getBytes());
						Buff.write((String.valueOf(middle)+" ,").getBytes());
						Buff.write("right:".getBytes());
						Buff.write((String.valueOf(right)+" ,").getBytes());
						Buff.write("\r\n".getBytes());
						if(right-left==1){//two elements left
							if(phone >= filelistd.get(left) && phone < filelistd.get(right))
								break;
							if(phone >= filelistd.get(right))
							{
								middle=right;
								break;
							}
						}
						
						if(phone >= filelistd.get(middle) && phone < filelistd.get(middle+1))
							break;
						if(phone < filelistd.get(middle) ){
							right=middle-1;
							
						}
						else if( phone > filelistd.get(middle)){
							left = middle+1;
						}
						else if(phone == filelistd.get(middle)){
							break;
						}
					}
					//System.out.println(filelistd.get(middle).toString());
					BigDecimal bigD= new  BigDecimal(filelistd.get(middle));
					System.out.println(bigD);
					String filefullpath = dirpath+"/"+fileIndex.get(bigD.toString());
					Buff.write(("get the file,file name is "+filefullpath).getBytes());
					
					BufferedReader br = new BufferedReader(new FileReader(filefullpath));
					String st = null;
					while((st=br.readLine())!=null){
						if(st.startsWith(phonestr)){
							Buff.write(st.getBytes());
							Buff.write("\r\n".getBytes());
							return st;
						}
					}
					br.close();
					Buff.flush();
					Buff.close();
					return errorStr[2]+" | "+filefullpath;
				}
				
			}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			Buff.flush();
			Buff.close();
		}
		return errorStr[3];
	}

	
	
	
}
