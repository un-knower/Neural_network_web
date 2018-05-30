import java.io.IOException;
import java.io.PrintWriter;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.python.antlr.PythonParser.return_stmt_return;

import test.testPython;

@WebServlet("/doPredict")
public class CheckServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	private static Dictionary<String, String> appDic = new Hashtable<>();
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("has bee here");
		String phone=req.getParameter("phone");
		if(isphone(phone)==false)
		{
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.print("<script>alert('phone number format is wrong! Please reinput'); window.location='IndexPage.jsp' </script>");
			out.flush();
			out.close();
			return;
		}
		resp.setContentType("text/html;charset=UTF-8");
		
		GetUserInfo get = new GetUserInfo();
		String result=get.searchNumber(phone, "../../../splitfile");//"D:\\javaee\\Workspace\\Display_4Flour\\file");
		System.out.println("result file:"+result);
		if(result.startsWith("1")){
			testPython py = new testPython();
			if(req.getAttribute("info")!=null)
			{
				req.removeAttribute("info");
			}
			if(appDic.isEmpty()==true)
			{
				appDic.put("C946", "腾讯视频");
				appDic.put("C370", "爱奇艺视频");
				appDic.put("C688", "乐视视频");
				appDic.put("C729", "芒果TV");
				appDic.put("C700", "沃手机电视");
				appDic.put("C1107", "优酷视频");
				appDic.put("C223897", "华数手机电视");
				appDic.put("C225569", "BesTV");
			}
			String appID = py.Streampython(result,"../webapps/resoures/LoadModel.py");
			
			req.setAttribute("info", appDic.get(appID));//"D:\\javaee\\Workspace\\Display_4Flour\\python\\testTF.py")));
		}
		else
		{
			if(result.contains("file found")){
				result="爱奇艺视频     | 腾讯视频";
				req.setAttribute("info", result);
			}
			else{
			req.setAttribute("info", "Error:"+result);
			}
		}	
		req.getRequestDispatcher("IndexPage.jsp").forward(req, resp);
		
		//https://www.cnblogs.com/biehongli/p/6424406.html
	}
	protected boolean isphone(String phone) {
		String PHONE_PATTERN="^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|16[0-9]|(147))\\d{8}$";
		return Pattern.compile(PHONE_PATTERN).matcher(phone).matches();
	}
}