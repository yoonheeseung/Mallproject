package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Board76DAO;
import com.naver.model.BoardBean;

public class BoardDelAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setContentType("text/html; charset=utf-8");
		//웹상에 출력되는 언어코딩 타입을 설정함. 한글을 안깨지게 한다.
		PrintWriter out =response.getWriter(); //출력 스트림 객체 생성
		
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		//히든으로 넘어온 글번호를 정수형 숫자로 바꿔서 저장
		
		int page=1;
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		String del_pwd=request.getParameter("del_pwd").trim();
		//비밀번호 저장
		
		System.out.println("입력번호:"+del_pwd);
				
		Board76DAO bd=new Board76DAO();
		
		BoardBean db_pwd=bd.getBoardCont(board_no);
		
		System.out.println("비번: "+"'"+db_pwd.getBoard_pwd()+"'");
		
		//번호에 해당하는 비번을 가져옴
		if(!db_pwd.getBoard_pwd().equals(del_pwd)){
			out.println("<script>");
			out.println("alert('비번이 다릅니다!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}else{
			bd.deleteBoard(board_no);
			
			response.sendRedirect("board_list.do?page="+page);
	    	//get방식으로 쪽번호를 넘기면서 목록으로 이동
		}
		return null;
	}
}
