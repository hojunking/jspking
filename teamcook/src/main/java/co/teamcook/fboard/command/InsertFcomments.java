package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FcommentsVO;
import co.yedam.teamcook.common.Command;

public class InsertFcomments implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새 댓글 작성
		FboardService dao = new FboardServiceImpl();
		FcommentsVO vo = new FcommentsVO();
		vo.setfCno(Integer.valueOf(request.getParameter("fNo")));
		vo.setfcName(request.getParameter("fcName"));
		vo.setfcSubject(request.getParameter("fcSubject"));
		
		int n = dao.fcommentsInsert(vo);
		String view = "";
		if (n != 0) {
			request.setAttribute("fNo", vo.getfCno());
			view = "searchFboard.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}
}
