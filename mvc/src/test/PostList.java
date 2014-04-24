package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PostBean;
import dao.PostDAO;

public class PostList extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//get or post에 상관없입 호출되는는 메서드는 service()
		PostDAO pd=new PostDAO();
		
		List<PostBean> plist=pd.getPList();
		//하나이상의 목록을 가져와 컬렉션 제네릭에 저장한다.
		
		request.setAttribute("list", plist);//문자열 키 list에 plist컬렉션 제네릭이 Object형으로 업케스팅되면서
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//값으로 저장
		/*
		 * list 키값을 reponse.sendRedirect();로 이동하면 완전히 새로운
		 * 페이지로 새로고침해서 이동하기 때문에 값을 잃어 버린다.
		 * NullPointException오류 발생함.
		 */
		RequestDispatcher dispatcher =
				request.getRequestDispatcher("./servlet/list.jsp");
		dispatcher.forward(request, response);
		
		//list키값을 유지할려면 RequestDispatcher 객체를 구해서 forward()
		//메서드로 이동해야 한다. list.jsp 뷰페이지로 이동한다.
				
	}
	
	

}
