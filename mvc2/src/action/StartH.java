package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class StartH extends HttpServlet {
	/*
	 * 월말평가 문제
	 *  서블릿 자바 정리
	 *   1.서블릿 클래스는 HttpServlet 클래스로 부터 상속받아서
	 *   만든다.
	 *   2.서블릿 클래스는 외부 패키지에서 누구나 다 접근할 수
	 *   있게 public 접근지정자로 만든다.
	 *   3.get방식으로 접근할 때는 doGet() 메서드를 오버라이딩
	 *    해서 호출한다.
	 *   4.post방식으로 접근할 때는 doPost()메서드를 오버라이딩
	 *   해서 호출한다.
	 *   5.get or post에 상관없이 service()메서드를 오버라이딩 해
	 *   서 호출한다.
	 *   6.HttpServletRequest 서블릿 클래스는 사용자 폼에서 입력한
	 *   정보를 서버로 가져올 때 사용한다.
	 *   7.HttpServletResponse 서블릿 클래스는 서버의 가공된 정보
	 *   를 사용자 웹브라우저에 응답할 때 사용한다.    
	 */
	
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//웹브라우저에 출력하는 언어코딩 타입 설정.출력되는
		//한글을 안깨지게 한다.
		PrintWriter out=response.getWriter();
		//출력스트림 객체 생성:월말 평가문제
		out.println("최초 서블릿 실행");
	}
}










