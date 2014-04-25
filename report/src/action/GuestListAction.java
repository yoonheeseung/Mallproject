package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Guest33DAO;
import com.naver.model.GuestBean;


public class GuestListAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		/* 복사시작 */
		Guest33DAO guestdao = new Guest33DAO();

		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		int listcount = guestdao.getListCount(); // 총 리스트 수를 받아옴.
		List<GuestBean> guestlist = guestdao.getGuestList(page, limit); // 리스트를
																		// 받아옴.

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
		request.setAttribute("guestlist", guestlist);
		/* 복사끝 */

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);// forward에서 분기되므로 키값유지
		forward.setPath("./jsp/guest/guest_list.jsp");
		return forward;
	}
}
