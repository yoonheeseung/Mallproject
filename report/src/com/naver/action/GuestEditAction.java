package com.naver.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;
import com.naver.dao.Guest33DAO;
import com.naver.model.GuestBean;


public class GuestEditAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
  response.setContentType("text/html;charset=utf-8");
  //웹상에 출력되는 언어코딩 타입을 설정
  PrintWriter out=response.getWriter();
  request.setCharacterEncoding("utf-8");
  //form태그의 method=post방식으로 넘어온 한글을 아깨지게 함.
    int guest_no = Integer.parseInt(request.getParameter("guest_no"));
    //히든으로 넘어온 번호값을 정수형 숫자로 바꿔서 저장
    int page=1;
    if(request.getParameter("page") !=null){
    	page=Integer.parseInt(request.getParameter("page"));
    	//페이지 번호값 저장
    }
    
    String guest_name=request.getParameter("guest_name");
    String guest_title=request.getParameter("guest_title");
    String guest_pwd=request.getParameter("guest_pwd");
    String guest_cont=request.getParameter("guest_cont");
    
    System.out.println("-------------------------------");
    System.out.println("BoradAction-name"+guest_name);
    System.out.println("BoradAction-title"+guest_title);
    System.out.println("BoradAction-pwd"+guest_pwd);
    System.out.println("BoradAction-cont"+guest_cont);
    
    Guest33DAO gd=new Guest33DAO();
    
    GuestBean db_pwd=gd.getGuestCont(guest_no);
    //데이터베이스로부터 비번을 가져옴.
    
    System.out.println("db_pwd: "+db_pwd.getGuest_pwd());
    
    if(db_pwd.getGuest_pwd().equals(guest_pwd)){
    	GuestBean eb=new GuestBean();
    	eb.setNo(guest_no);
    	eb.setGuest_name(guest_name);
    	eb.setGuest_title(guest_title);
    	eb.setGuest_cont(guest_cont);
    	
    	
    	gd.editGuest(eb);//
    	
    	ActionForward forward=new ActionForward();
    	forward.setRedirect(true);
    	forward.setPath("guest_cont.do?guest_no="+guest_no+"&page="+page+"&state=cont");
    	System.out.println("return forward!!!");
    	return forward;
    }else{
    	out.println("<script>");
    	out.println("alert('password is not matched!')");
    	out.println("history.go(-1)");
    	out.println("</script>");
    }
     return null;
    
	}

}
