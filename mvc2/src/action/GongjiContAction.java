package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GongjiBean;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;

import dao.GongjiDAO;

public class GongjiContAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		int page=1;
		if(request.getParameter("page") != null){
       page=Integer.parseInt(request.getParameter("page"));			
		}
		
		int no=Integer.parseInt(request.getParameter("no"));
		GongjiDAO gd=new GongjiDAO();
		
		gd.updateHit(no);//조회수 증가
		
		GongjiBean g=gd.getGongjiCont(no);
		//번호에 해당하는 디비로 부터 공지값을 가져옴.
		String gongji_cont=
				g.getGongji_cont().replace("\n","<br/>");
		//textarea박스에서 엔터키 친 부분을 다음줄로 개행
		
		request.setAttribute("g",g);
		request.setAttribute("gongji_cont",gongji_cont);
		request.setAttribute("page",page);
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./jsp/gongji/gongji_cont.jsp");
		return forward;

	}

}
