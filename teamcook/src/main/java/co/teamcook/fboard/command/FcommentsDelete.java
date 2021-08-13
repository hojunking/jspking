package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FcommentsVO;
import co.yedam.teamcook.common.Command;

public class FcommentsDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 자유게시판 댓글 삭제
		FboardService dao = new FboardServiceImpl();
		FcommentsVO vo = new FcommentsVO();
		vo.setfCno(Integer.valueOf(request.getParameter("fcdel")));
		int n = dao.fcommentsDelete(vo);
		String view = "";
		if (n != 0) {
			view = "fboardMain.do";
		} else {
			request.setAttribute("message", "자유게시판 댓글 삭제에 문제가 있었어요!!! 끼약");
			view = "home/error";
		}
		return view;
	}

}
