package com.mtory.action;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MemberFrontController extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response)
	throws IOException, ServletException{
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		 
		 Properties prop=new Properties();
		 FileInputStream fis=
//				 new FileInputStream("C:/Documents and Settings/unisung/git/MyProject/MallProject/src/conf/file/props/Member.properties");
		  new FileInputStream("C:/Users/admin/git/MyProject/MallProject/src/conf/file/props/Member.properties");
		 prop.load(fis);
		 fis.close();
		 String value=prop.getProperty(command);
		 
		 if(value.substring(0,7).equals("execute")){
			 try {
				StringTokenizer st=new StringTokenizer(value,"|");
				String url_1=st.nextToken();
				String url_2=st.nextToken();
				@SuppressWarnings("rawtypes")
				Class url=Class.forName(url_2);
				action = (Action) url.newInstance();
				try {
					forward=action.execute(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			 }catch(ClassNotFoundException ex){
					ex.printStackTrace();
				}catch(InstantiationException ex){
					ex.printStackTrace();
				}catch(IllegalAccessException ex){
					ex.printStackTrace();
				}
			}else{
				forward=new ActionForward();
				forward.setRedirect(false);
				forward.setPath(value);
			}
		
		 if(forward != null){
		 if(forward.isRedirect()){
			 response.sendRedirect(forward.getPath());
		 }else{
			 RequestDispatcher dispatcher=
				 request.getRequestDispatcher(forward.getPath());
			 dispatcher.forward(request, response);
		 }	 
		 }
	}
}