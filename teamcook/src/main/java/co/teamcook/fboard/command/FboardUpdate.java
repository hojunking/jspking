package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class FboardUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정
		FboardService dao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		vo.setfNo(Integer.valueOf(request.getParameter("fNo")));
		vo.setfTitle(request.getParameter("fTitle"));
		vo.setfContents(request.getParameter("fContents"));

		int n = dao.fboardUpdate(vo);
		String view = "";
		if (n != 0) {
			request.setAttribute("fNo", vo.getfNo());
			view = "searchFboard.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}
}
