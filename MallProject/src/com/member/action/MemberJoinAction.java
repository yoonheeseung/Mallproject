package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;



public class MemberJoinAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward=new ActionForward();
		forward.setRedirect(true);
		forward.setPath("./member/member_join.jsp");
		return forward;
	}

}
