package com.mtory.action;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;

import java.util.*;

@SuppressWarnings("serial")
public class MtoryFrontController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;

		Properties prop = new Properties();
		FileInputStream fis = 
				new FileInputStream("C:\\home_work\\report\\build\\classes\\mtory.properties");
		
		prop.load(fis);
		System.out.println(fis);
		fis.close();
		String value = prop.getProperty(command);
		System.out.println(value);
        
		if(value.substring(0,7).equals("execute")){
			try{
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken();//첫번째 분리된문자열 전단
				String url_2 = st.nextToken();//두번째 분리된 문자열 전달
				Class url = Class.forName(url_2);//두번째 분리된 컨트롤 클래스를 로드해서 실행
				
				System.out.println("url_1: "+url_1);
				System.out.println("url_2: "+url_2);
				
				action  = (Action)url.newInstance();
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
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);

			}
		}
	} 	    
}
