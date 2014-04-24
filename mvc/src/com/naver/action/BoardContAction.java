package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Board76DAO;
import com.naver.model.BoardBean;

public class BoardContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			// get방식으로 넘어온 글번호를 정수형 숫자로 바꿔서 저장
		}
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String status = request.getParameter("state");
		// 내용보기일때는 cont, 답변글 폼 reply, 수정폼 edit, 삭페폼 del
		System.out.println("BoardContAction-board_no: "+board_no);
		System.out.println("BoardContAction-satus: "+status);
		
		Board76DAO bd = new Board76DAO();

		if (status.equals("cont")) {
			bd.updateHit(board_no);
		}
		BoardBean bcont = bd.getBoardCont(board_no);
		// 번호에 해당하는 내용을 디비로 부터 가져온다.
		String board_cont = bcont.getBoard_cont().replace("\n", "<br/>");
		// 글내용을 입력할때 textarea박스에서 엔터기 친 부분을 내용보기에서 다음 줄로 개행시켜라.

		/*********************************************/
		request.setAttribute("bcont", bcont);
		request.setAttribute("page", page);//이전페이지 쪽번호로 가기위한 페이지번호 저장
		/********************************************/

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);

		if (status.equals("cont")) {
			request.setAttribute("board_cont", board_cont);
			forward.setPath("./jsp/board/board_cont.jsp");
		} else if (status.equals("reply")) {
			request.setAttribute("board_cont", board_cont);
			forward.setPath("./jsp/board/board_reply.jsp");
		} else if (status.equals("edit")) {
			forward.setPath("./jsp/board/board_edit.jsp");
		} else if (status.equals("del")) {
			forward.setPath("./jsp/board/board_del.jsp");
		}

		return forward;
	}

}
