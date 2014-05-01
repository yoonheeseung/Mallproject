package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GongjiBean;

import com.mtory.action.Action;
import com.mtory.action.ActionForward;

import dao.GongjiDAO;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		GongjiDAO gd=new GongjiDAO();
		List<GongjiBean> glist=gd.getGList();
		//공지 테이블로부터 공지목록을 가져온다.
		
		request.setAttribute("glist",glist);
		
		
		ActionForward forward=new ActionForward();
		forward.setRedirect(false);
		forward.setPath("index.jsp");
		return forward;
	}

}
