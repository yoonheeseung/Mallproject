package com.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.dao.MemberDAO;
import com.mtory.action.Action;
import com.mtory.action.ActionForward;


public class MemberIDCheckAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception{
		ActionForward forward=new ActionForward();
		
		String id=request.getParameter("MEMBER_ID");
		
		MemberDAO memberdao=new MemberDAO();
		int check=memberdao.confirmId(id);	
		
		request.setAttribute("id", id);
		request.setAttribute("check", check);
		
		forward.setRedirect(false);
		forward.setPath("./member/member_idchk.jsp"); 			
		return forward;
	}
}