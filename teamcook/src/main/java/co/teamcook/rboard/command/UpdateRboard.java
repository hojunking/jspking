package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class UpdateRboard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정
		RboardService dao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		vo.setrTitle(request.getParameter("rTitle"));
		vo.setrContent(request.getParameter("rContent"));
		vo.setrNo(Integer.valueOf(request.getParameter("rNo")));
		int n = dao.rboardUpdate(vo);
		String view = "";
		if(n != 0) {
			request.setAttribute("rboard", vo);
			view = "searchRboard.do";
		}
		return view;
	}

}
