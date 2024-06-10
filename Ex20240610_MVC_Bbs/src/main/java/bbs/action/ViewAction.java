package bbs.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class ViewAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (UnsupportedEncodingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		String bname = request.getParameter("bname");
		String b_idx = request.getParameter("b_idx");
		String viewPath = null;
		
		BbsVO bvo = BbsDAO.getView(/*bname,*/b_idx);
		
		if(bvo != null) {
			request.setAttribute("bvo", bvo);
			viewPath = "/jsp/"+bname+"/view.jsp";
		}
		
		return viewPath; // 뷰페이지의 경로를 반환한다.
	}

}
