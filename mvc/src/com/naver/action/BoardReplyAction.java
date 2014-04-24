package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Board76DAO;
import com.naver.model.BoardBean;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
	    //form태그에서 method=post방식일때 서버에서 받는 한글을 한깨지게 한다.
		int page=1;
		if(request.getParameter("page") != null){
		page=Integer.parseInt(request.getParameter("page"));
		}
		int board_no=Integer.parseInt(request.getParameter("board_no").trim());
		int board_ref=Integer.parseInt(request.getParameter("board_ref").trim());
		int board_step=Integer.parseInt(request.getParameter("board_step").trim());
		int board_level=Integer.parseInt(request.getParameter("board_level").trim());
		//히든으로 넘어온 번호값을 정수형 숫자로 바꿔서 저장
		String board_name=request.getParameter("board_name").trim();
		String board_title=request.getParameter("board_title").trim();
		String board_pwd=request.getParameter("board_pwd").trim();
		String board_cont=request.getParameter("board_cont").trim();
		System.out.println("BoardReply-board_name:"+board_name);
		System.out.println("BoardReply-board_title:"+board_title);
		System.out.println("BoardReply-board_pwd:"+board_pwd);
		System.out.println("BoardReply-board_cont:"+board_cont);
		
		BoardBean br=new BoardBean();
		
		br.setBoard_no(board_no);
		br.setBoard_ref(board_ref);
		br.setBoard_step(board_step);
		br.setBoard_name(board_name);
		br.setBoard_title(board_title);
		br.setBoard_level(board_level);
		br.setBoard_pwd(board_pwd);
		br.setBoard_cont(board_cont);
		
		Board76DAO bd=new Board76DAO();
		
		bd.replyBoard(br);//답변글 저장
		System.out.println("-------------");
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("board_list.do?page="+page);
		
		return forward;
	}
}
