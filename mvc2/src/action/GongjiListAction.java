package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GongjiBean;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;

import dao.GongjiDAO;

public class GongjiListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		GongjiDAO boarddao = new GongjiDAO();
		int page = 1;
		int limit = 7;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int listcount = boarddao.getListCount(); // 총 리스트 수를 받아옴.
		List<GongjiBean> glist = boarddao.getGongjiList(page, limit); //공지목록

		// 총 페이지 수.
		int maxpage = (int) ((double) listcount / limit + 0.95); // 0.95를 더해서 올림
																	// 처리.
		// 현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		// 현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;

		if (endpage > startpage + 10 - 1)
			endpage = startpage + 10 - 1;

		request.setAttribute("page", page); // 현재 페이지 수.
		request.setAttribute("maxpage", maxpage); // 최대 페이지 수.
		request.setAttribute("startpage", startpage); // 현재 페이지에 표시할 첫 페이지 수.
		request.setAttribute("endpage", endpage); // 현재 페이지에 표시할 끝 페이지 수.
		request.setAttribute("listcount", listcount); // 글 수.
		request.setAttribute("glist", glist);
		/* 복사끝 */

			
		ActionForward forward=new ActionForward();
	    forward.setRedirect(false);
	    forward.setPath("./jsp/gongji/gongji_list.jsp");
		return forward;

		
		/*
		 * 과제물
		 *  1.수정/삭제 버튼이 빠진 번호,제목,작성자,조회수,날짜
		 *  제목으로 출력되는 공지목록페이지 gongji_list.jsp
		 *  작성하시면 됩니다.
		 *  2.페이징이 되야 합니다. 한페이지에 10개 목록이 나오게
		 *  하세요. 공지작성 버튼 빼야 합니다.
		 *  3.공지제목 클릭시...다시 gongji_cont.html로 이동하면
		 *  됩니다. 점심시간 포함해서 5교시 까지 해결하시면 됩니다.
		 */
		
	}

}
