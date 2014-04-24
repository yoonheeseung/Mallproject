package test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostBean;
import dao.PostDAO;

public class PostOK extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name").trim();
		String cont=request.getParameter("cont").trim();
		
		PostBean pb=new PostBean();
		
		pb.setName(name);
		pb.setCont(cont);
		
		PostDAO pd=new PostDAO();
		
		pd.insertPost(pb);//저장메서드 호출
		
		response.sendRedirect("/mvc/p_list");//목록으로 이동
		//mvc 는 server.xml의 Context path="/mvc"에서 인식한다.
		///p_list는 WEB-INF/web.xml 배포서술자의 url-pattern에서 인식해서
		//해당 서블릿 자바로 이동한다.		
	}

	
}
