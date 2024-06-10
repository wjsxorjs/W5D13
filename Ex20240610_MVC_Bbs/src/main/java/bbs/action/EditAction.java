package bbs.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bbs.util.Paging;
import mybatis.dao.BbsDAO;
import mybatis.vo.BbsVO;

public class EditAction implements Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse reponse) {
		
//		현재객체를 호출하는 곳은 적어도 두 군데다.
//		1) view.jsp에서 [수정]버튼을 클릭했을때 : get
//		2) edit.jsp에서 [저장]버튼을 클릭했을때 : post(Multipart)
//		

		String viewPath = null;

		String enc_type = request.getContentType();

		String source = request.getParameter("source");
		
		
		if(enc_type.startsWith("application") && source.equals("view")) {
			String b_idx = request.getParameter("b_idx");
			String bname = request.getParameter("bname");
			
			
			BbsVO bvo = BbsDAO.getView(b_idx);
			request.setAttribute("bvo", bvo);

			viewPath = "/jsp/"+bname+"/edit.jsp";
		} else if(enc_type.startsWith("multipart") && source == null) {

		}
		
		
		return viewPath; // 뷰페이지의 경로를 반환한다.
	}

}
