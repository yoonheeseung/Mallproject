package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddrBean;
import myUtil.HanConv;
import dao.AddrDAO;

public class GetOK extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response)
			throws ServletException, IOException {
	//service() 메서드는 get or post에 상관없이 호출
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();//출력스트림 객체 생성
		
   String name=HanConv.toKor(request.getParameter("name").trim());
       //name=new String(name.getBytes("8859_1"),"UTF-8");
        /*
         * jsp월말 평가
         *  1.get으로 넘어오는 한글은 깨진다. 안깨지게 할려면 String
         *  클래스의 getBytes()메서드를 사용하여 언어코딩 타입을 UTF-8
         *  로 바꿔야 한다.
         */
        String addr=request.getParameter("addr").trim();
        addr=new String(addr.getBytes("8859_1"),"UTF-8");
        String phone=request.getParameter("phone").trim();
        String email=request.getParameter("email").trim();
        
        out.println("이름=>"+name+"<hr/>");
        out.println("주소=>"+addr+"<hr/>");
        out.println("폰번호=>"+phone+"<hr/>");
        out.println("전자우편=>"+email+"<hr/>");
	
        AddrBean ab=new AddrBean();
        ab.setName(name); ab.setAddr(addr);
        ab.setPhone(phone); ab.setEmail(email);
        
        AddrDAO ad=new AddrDAO();
        
        ad.insertAddr(ab);//저장메서드 호출
	}	
}






