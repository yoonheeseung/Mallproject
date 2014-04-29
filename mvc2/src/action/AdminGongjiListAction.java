package action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GongjiBean;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;

import dao.GongjiDAO;

public class AdminGongjiListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		String admin_id=(String)session.getAttribute("admin_id");
		
		if(admin_id==null){
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='admin_login.html'");
			out.println("</script>");
		}else{
		/*복사시작*/
		GongjiDAO gd=new GongjiDAO();
		
		int page=1;
		int limit=7;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
			//get방식으로 넘어온 쪽번호를 받아서 정수형 숫자로 바꿔서 저장
		}
		
		int listcount=gd.getListCount(); 
		//총 리스트 수를 받아옴.
		
		List<GongjiBean> glist = gd.getGongjiList(page,limit); 
		//공지 목록
		
		//총 페이지 수.
   		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리.
   		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
   		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
   		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
   		int endpage = maxpage;
   		
   		if (endpage>startpage+10-1) endpage=startpage+10-1;
   		
   		request.setAttribute("page", page);		  //현재 페이지 수.
   		request.setAttribute("maxpage", maxpage); //최대 페이지 수.
   		request.setAttribute("startpage", startpage); //현재 페이지에 표시할 첫 페이지 수.
   		request.setAttribute("endpage", endpage);     //현재 페이지에 표시할 끝 페이지 수.
		request.setAttribute("listcount",listcount); //글 수.
		request.setAttribute("glist", glist);//목록
		/*복사끝*/
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./jsp/admin/admin_gongji_list.jsp");
		return forward;
	}
		return null;
}
}
