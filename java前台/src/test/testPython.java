package test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.python.antlr.ast.arguments.args_descriptor;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class testPython {

	// public static void main(String[] args){
	// //PythonInterpreter interpreter = new PythonInterpreter();
	// //interpreter.execfile(".//python//testTF.py");
	// testPython py= new testPython();
	// py.Streampython("1");
	// //py.callpython();//找不到tensorflow模块
	//
	// }

	public String Streampython(String sysarg, String pythofile) throws IOException {
		String[] arguments = new String[] { "python", pythofile, sysarg };
		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		try {
			/////////////////////////////////////////////////////////
			File Log = new File("../../loggingpython.txt");
			if (!Log.exists()) {
				Log.createNewFile();
			}
			outSTr = new FileOutputStream(Log);
			Buff = new BufferedOutputStream(outSTr);
			long begin0 = System.currentTimeMillis();
			///////////////////////////////////////////////////////////

			File file = new File(pythofile);
			if (file.exists()) {
				System.out.println(file.getAbsolutePath());
				Buff.write(("python file path is "+file.getAbsolutePath()+" --\r\n").getBytes());
				Buff.write(("python args is"+sysarg+" --\r\n").getBytes());
			}
			else
			{
				Buff.write("no file\r\n".getBytes());
				Buff.write(file.getAbsolutePath().getBytes());
				
			}

			Process process = Runtime.getRuntime().exec(arguments);// 执行python文件
			
			Buff.write("\r\nRunTime\r\n".getBytes());
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			
			
			// System.out.println("1111111111111");
			String line = null;
			StringBuilder stler = new StringBuilder();
			int i =0;
			while ((line = in.readLine()) != null) {
				stler.append(line);// 打印在python运行过程中的一行行文字
				System.out.println(line);
				Buff.write(("\r\n "+(++i)+" line:"+line).getBytes());
			}
			
			//////////////////////////////////////////////////////////
			i =0;
			while ((line = error.readLine()) != null) {
				Buff.write("======ERROR=================\r\n".getBytes());
				Buff.write(("\r\n "+(++i)+" line:"+line).getBytes());
			}
			
			/////////////////////////////////////////////////////////
			
			Buff.write("\r\nline got done".getBytes());
			// System.out.println("===="+stler.toString());
			in.close();
			int re = process.waitFor();
			Buff.write(("\r\n process.waitFor():"+re+"--").getBytes());
			Buff.write(("\r\n stler:"+stler.toString()+"--\r\n").getBytes());
			return stler.toString();
		} catch (Exception e) {
			e.printStackTrace();
			Buff.write(e.getMessage().getBytes());
			Buff.write("\r\n ERROR.\r\n".getBytes());
		}
		finally {
			Buff.flush();
			Buff.close();
		}
		return null;
	}

	

	// 下面这个函数获取不到tensorflow模块，所以不能用
	public void callpython() {
		PythonInterpreter interpre = new PythonInterpreter();
		interpre.execfile(".//python//testTF.py");
		PyFunction func = (PyFunction) interpre.get("compute", PyFunction.class);
		PyObject pyObj = func.__call__();// 如果有参数，就是new
											// PyString("fjslj"),逗号分隔多个参数
		System.out.println(pyObj.toString());
	}

}
