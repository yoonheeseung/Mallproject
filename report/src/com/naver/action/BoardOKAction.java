package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Board76DAO;
import com.naver.model.BoardBean;

public class BoardOKAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
           
	     request.setCharacterEncoding("utf-8");
	     
	     String board_name= request.getParameter("board_name").trim();
	     String board_title = request.getParameter("board_title").trim();
	     String board_pwd= request.getParameter("board_pwd").trim();
	     String board_cont = request.getParameter("board_cont").trim();
	     
	     BoardBean b=new BoardBean();//저장 Bean객체 생성
	     b.setBoard_name(board_name);
	     b.setBoard_title(board_title);
	     b.setBoard_cont(board_cont);
	     b.setBoard_pwd(board_pwd);
	     
	     Board76DAO bd=new Board76DAO();
	     
	     bd.insertBoard(b);//저장메서드 호출
	     /*
	      * 일 과제물
	      * 1. 내일 첫교시까지 저장메서드를 완성하세요!
	      * 2. board_hit필드 레코드값은 default 0 제약조건에 의해서 레코드를 지정하지 않아도 됨
	      * 3. board_no,board_ref(글 그룹번호)는 시퀀스로 부터 값을 가져와 저장하면 됩니다.
	      * 4. board_step,board_level은 정수형 0을 저장하세요.
	      * 5. board_date 오라클 날짜함수 sysdate를 사용하시면됩니다.
	      */
	   
	     ActionForward forward=new ActionForward();
//			forward.setPath("./jsp/board/board_write.jsp");
	        forward.setPath("board_list.do");
			//jsp/board폴더의 board_write.jsp 뷰페이지가 실행된다.
			forward.setRedirect(true);
			return forward;

	}

}
