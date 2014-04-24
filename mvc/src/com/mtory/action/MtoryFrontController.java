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
	/* 
	 * 서블릿 클래스의 특징
	 *  1.서블릿 클래스를 만들려면 HttpServlet로 부터 상속을 받는다.
	 *  2.서블릿 자바클래스는 외부 패키지 누구나 다 접근할 수 있게
	 *    public 접근지정자로 정의한다.
	 *  3.get방식으로 접근할때는 doGet()메서드로 호출한다.
	 *  4.post방식으로 접근할때는 doPost()메서드로 호출한다.
	 *  5.get or post에 상관없이 service메서드를 호출한다.
	 *  6.HttpServletRequest 서블릿 클래스는 사용자 폼에서 입력한 정보를 서버로 가져올때 사용한다.
	 *  7.HttpServletResponse 서블릿 클래스는 서버의 가공된 정보를 사용자 웹상에 응답할때 사용한다.
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		System.out.println("Cntr-RequestUri: "+RequestURI);
		String contextPath=request.getContextPath();
		System.out.println("Cntr-contextPath: "+contextPath);
		String command=RequestURI.substring(contextPath.length());
		System.out.println("Cntr-command: "+command);
		ActionForward forward=null;
		Action action=null;

		Properties prop = new Properties();
		FileInputStream fis = 
				new FileInputStream("C:\\stswork2\\mvc\\build\\classes\\mtory.properties");
//		        new FileInputStream("c:\\stswork2/mvc/build/classes/mtory.properties");
//		new FileInputStream("C:\\stswork2\\mvc\\src\\mtory.properties");
		/* 자바 폴더 경로구분은 \\ or / 처리한다.  \는 안됨*/
	
		
		prop.load(fis);
		System.out.println("Cntr-fis: "+fis);
		fis.close();
		String value = prop.getProperty(command);
		System.out.println("Cntr-value: "+value);
        
		if(value.substring(0,7).equals("execute")){
			try{
				StringTokenizer st = new StringTokenizer(value,"|");
				String url_1 = st.nextToken();//첫번째 분리된문자열 전단
				System.out.println("url_1: "+url_1);
				String url_2 = st.nextToken();//두번째 분리된 문자열 전달
				System.out.println("url_1: "+url_2);
				Class url = Class.forName(url_2);//두번째 분리된 컨트롤 클래스를 로드해서 실행
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
				/*
				 * sendRedirect("이동할 경로 파일명");메서드로 원하는
				 * 파일로 이동하면 새로고침해서 새로운 페이지로 이동을 한다.
				 * 그러므로 컨트롤 클래스에서
				 * request.setAttribute(키,값);쌍으로 저장된 키값을 잃어버림
				 * <<<session키값은 잃어버리지 않음>>>
				 * 
				 */
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
				/*request.setAttribute(키,값);쌍으로 저장된 키값을 유지할려면
				 * RequestDispatcher객체를 구해서 forward()
				 * 메서드로 이동해야 키 값을 유지할 수 있다.
				 */
			}
		}
	} 	    
}
