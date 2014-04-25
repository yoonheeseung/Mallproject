package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Guest33DAO;
import com.naver.model.GuestBean;


public class GuestContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("???");
		int page = 1;
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			// get방식으로 넘어온 글번호를 정수형 숫자로 바꿔서 저장
		}
		int guest_no = Integer.parseInt(request.getParameter("guest_no"));
		String status = request.getParameter("state");
		// 내용보기일때는 cont, 답변글 폼 reply, 수정폼 edit, 삭페폼 del
		System.out.println("BoardContAction-board_no: "+guest_no);
		System.out.println("BoardContAction-satus: "+status);
		
		Guest33DAO guestdao = new Guest33DAO();

		if (status.equals("cont")) {
			guestdao.updateHit(guest_no);
		}
		System.out.println("-----");
		GuestBean gcont = guestdao.getGuestCont(guest_no);
		// 번호에 해당하는 내용을 디비로 부터 가져온다.
		String guest_cont = gcont.getGuest_cont().replace("\n", "<br/>");
		// 글내용을 입력할때 textarea박스에서 엔터기 친 부분을 내용보기에서 다음 줄로 개행시켜라.

		/*********************************************/
		request.setAttribute("gcont", gcont);
		request.setAttribute("page", page);//이전페이지 쪽번호로 가기위한 페이지번호 저장
		/********************************************/

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		
          System.out.println(guest_cont);
          
		if (status.equals("cont")) {
			request.setAttribute("guest_cont", guest_cont);
			forward.setPath("./jsp/guest/guest_cont.jsp");
		} else if (status.equals("reply")) {
			request.setAttribute("guest_cont", guest_cont);
			forward.setPath("./jsp/guest/guest_reply.jsp");
		} else if (status.equals("edit")) {
			forward.setPath("./jsp/guest/guest_edit.jsp");
		} else if (status.equals("del")) {
			forward.setPath("./jsp/guest/guest_del.jsp");
		}

		return forward;
	}

}
