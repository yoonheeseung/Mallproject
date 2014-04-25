package com.naver.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Guest33DAO;
import com.naver.model.GuestBean;

public class GuestReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
	    //form태그에서 method=post방식일때 서버에서 받는 한글을 한깨지게 한다.
		int page=1;
		if(request.getParameter("page") != null){
		page=Integer.parseInt(request.getParameter("page"));
		}
		int guest_no=Integer.parseInt(request.getParameter("guest_no").trim());
		int guest_ref=Integer.parseInt(request.getParameter("guest_ref").trim());
		int guest_step=Integer.parseInt(request.getParameter("guest_step").trim());
		int guest_level=Integer.parseInt(request.getParameter("guest_level").trim());
		//히든으로 넘어온 번호값을 정수형 숫자로 바꿔서 저장
		String guest_name=request.getParameter("guest_name").trim();
		String guest_title=request.getParameter("guest_title").trim();
		String guest_pwd=request.getParameter("guest_pwd").trim();
		String guest_cont=request.getParameter("guest_cont").trim();
		
		System.out.println("guestReply-guest_name:"+guest_name);
		System.out.println("guestReply-guest_title:"+guest_title);
		System.out.println("guestReply-guest_pwd:"+guest_pwd);
		System.out.println("guestReply-guest_cont:"+guest_cont);
		
		GuestBean gr=new GuestBean();
		
		gr.setNo(guest_no);
		gr.setGuest_ref(guest_ref);
		gr.setGuest_step(guest_step);
		gr.setGuest_name(guest_name);
		gr.setGuest_title(guest_title);
		gr.setGuest_level(guest_level);
		gr.setGuest_pwd(guest_pwd);
		gr.setGuest_cont(guest_cont);
		
		Guest33DAO gd=new Guest33DAO();
		
		gd.replyGuest(gr);//답변글 저장
		System.out.println("-------------");
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("guest_list.do?page="+page);
		
		return forward;
	}
}
