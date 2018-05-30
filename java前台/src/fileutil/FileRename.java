package fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import org.python.antlr.base.boolop;
import org.python.objectweb.asm.commons.StaticInitMerger;

public class FileRename {
	
	public static Dictionary<String, String> filePhone =new Hashtable<String, String>();

	public static int renamefile(String dirpath, String filepre, Boolean rebool) throws FileNotFoundException {
		File file = new File(dirpath);
		if (!file.isDirectory()) {
			return -1;
		}
		String[] flist = file.list();
		
		int wrongname = 0;
		int failfile=0;
		try {
			for (int i = 0; i < flist.length; ++i) {
				System.out.println("Processing file : "+ flist[i]);
				if (!flist[i].startsWith(filepre)) {
					wrongname++;
					continue;
				}
				if (rebool == true) { // rename && get content file
					File ff = new File(flist[i]);
					
					BufferedReader reader = new BufferedReader(new FileReader(ff));
					
					if(flist[i].equals("f_000")){
						reader.readLine();
					}
					String line = reader.readLine();
					if(line!=null && line.startsWith("1")){
						int newName = Integer.parseInt(flist[i].split("_")[1]);
						File newf = new File(dirpath+newName);
						Boolean success = ff.renameTo(newf);
						if(success==false){
							failfile++;
							continue;
						}
						else{
							filePhone.put(line.split(",")[0], newf.getName());
							if(flist[i].equals("f_000")){
								filePhone.put("min",line.split(",")[0] );
							}
						}
					}
					if(flist[i].equals("f_260")){
						String max=null;
						while((line=reader.readLine())!=null){
							max=line;
						}
						filePhone.put("max",max.split(",")[0]);
					}
					reader.close();
					
				}
				else{//rebool==false
					
					File ff = new File(flist[i]);
					
					BufferedReader reader = new BufferedReader(new FileReader(ff));
					if(flist[i].equals("f_000")){
						reader.readLine();
					}
					String line = reader.readLine();
					if(line!=null && line.startsWith("1")){
						int newName = Integer.parseInt(flist[i].split("_")[1]);						
						filePhone.put(line.split(",")[0], String.valueOf(newName));
						if(flist[i].equals("f_000")){
							filePhone.put("min",line.split(",")[0] );
						}
					}
					if(flist[i].equals("f_260")){
						String max=null;
						while((line=reader.readLine())!=null){
							max=line;
						}
						filePhone.put("max",max.split(",")[0]);
					}
					reader.close();
				} //else{//rebool==false
			}//for (int i = 0; i < flist.length; ++i)
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
	
	public static void main(String args[]) throws FileNotFoundException{
		renamefile("./","f_",true);
		Enumeration<String> keys = FileRename.filePhone.keys();
		while(keys.hasMoreElements()) {
			String key=keys.nextElement();
			System.out.println("fileIndex.put(\""+key+"\", \""+filePhone.get(key)+"\");");
			
		}
		System.out.println("Program Done");
	}

}
