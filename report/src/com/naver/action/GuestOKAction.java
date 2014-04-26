package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Guest33DAO;
import com.naver.model.GuestBean;

public class GuestOKAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String guest_name = request.getParameter("guest_name").trim();
		String guest_title = request.getParameter("guest_title").trim();
		String guest_pwd = request.getParameter("guest_pwd").trim();
		String guest_cont = request.getParameter("guest_cont").trim();

		GuestBean g = new GuestBean();// 저장 Bean객체 생성
		
		g.setGuest_name(guest_name);
		g.setGuest_title(guest_title);
		g.setGuest_cont(guest_cont);
		g.setGuest_pwd(guest_pwd);

		Guest33DAO gd = new Guest33DAO();

		gd.insertG(g);// 10.저장메서드
		
		ActionForward forward = new ActionForward();
		forward.setPath("./jsp/guest/guest_write.jsp");
		forward.setPath("guest_list.do");
		forward.setRedirect(true);
		return forward;

	}

}
