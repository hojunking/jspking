package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class RboardUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청게시판 글 수정
		RboardService dao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		vo.setrNo(Integer.valueOf(request.getParameter("rNo")));
		vo.setrTitle(request.getParameter("rTitle"));
		vo.setrContent(request.getParameter("rContent"));
		int n = dao.rboardUpdate(vo);
		String view = "";
		if (n != 0) {
			request.setAttribute("rNo", vo.getrNo());
			view = "searchRboard.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}

}
