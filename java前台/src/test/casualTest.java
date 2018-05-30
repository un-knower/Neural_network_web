package test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import org.python.antlr.ast.alias.asname_descriptor;

public class casualTest {

	public static void main(String[] args) throws IOException {
//		String aString = "098";
//		int a = Integer.parseInt(aString);
//		System.out.println(a);
//
//		File Log = new File("./logging.txt");
//		if (!Log.exists()) {
//			Log.createNewFile();
//		}
//
//		FileOutputStream outSTr = null;
//		BufferedOutputStream Buff = null;
//
//		outSTr = new FileOutputStream(Log);
//		Buff = new BufferedOutputStream(outSTr);
//		long begin0 = System.currentTimeMillis();
//		for (int i = 0; i < 2; i++) {
//			Buff.write("测试java 文件操作\r\n".getBytes());
//		}
//		Buff.flush();
//		Buff.close();
//		long end0 = System.currentTimeMillis();
//		System.out.println("BufferedOutputStream执行耗时:" + (end0 - begin0) + " 毫秒");
 
		Dictionary<String, String> aDictionary = new Hashtable<>();
		aDictionary.put("1", "time");
		System.out.println(aDictionary.get("2"));
	}
}
