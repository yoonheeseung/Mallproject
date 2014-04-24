package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Board76DAO;
import com.naver.model.BoardBean;

public class BoardEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
  response.setContentType("text/html;charset=utf-8");
  //웹상에 출력되는 언어코딩 타입을 설정
  PrintWriter out=response.getWriter();
  request.setCharacterEncoding("utf-8");
  //form태그의 method=post방식으로 넘어온 한글을 아깨지게 함.
    int board_no = Integer.parseInt(request.getParameter("board_no"));
    //히든으로 넘어온 번호값을 정수형 숫자로 바꿔서 저장
    int page=1;
    if(request.getParameter("page") !=null){
    	page=Integer.parseInt(request.getParameter("page"));
    	//페이지 번호값 저장
    }
    
    String board_name=request.getParameter("board_name");
    String board_title=request.getParameter("board_title");
    String board_pwd=request.getParameter("board_pwd");
    String board_cont=request.getParameter("board_cont");
    
    System.out.println("-------------------------------");
    System.out.println("BoradAction-name"+board_name);
    System.out.println("BoradAction-title"+board_title);
    System.out.println("BoradAction-pwd"+board_pwd);
    System.out.println("BoradAction-cont"+board_cont);
    
    Board76DAO bd=new Board76DAO();
    
    BoardBean db_pwd=bd.getBoardCont(board_no);
    //데이터베이스로부터 비번을 가져옴.
    
    System.out.println("db_pwd: "+db_pwd.getBoard_pwd());
    
    if(db_pwd.getBoard_pwd().equals(board_pwd)){
    	BoardBean eb=new BoardBean();
    	eb.setBoard_no(board_no);
    	eb.setBoard_name(board_name);
    	eb.setBoard_title(board_title);
    	eb.setBoard_cont(board_cont);
    	
    	
    	bd.editBoard(eb);//
    	
    	ActionForward forward=new ActionForward();
    	forward.setRedirect(true);
    	forward.setPath("board_cont.do?board_no="+board_no+"&page="+page+"&state=cont");
    	System.out.println("return forward!!!");
    	return forward;
    }else{
    	out.println("<script>");
    	out.println("alert('password is not matched!')");
    	out.println("history.go(-1)");
    	out.println("</script>");
    }
     return null;
    
	}

}
