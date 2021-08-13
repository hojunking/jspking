package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.teamcook.rboard.vo.RcommentVO;
import co.yedam.teamcook.common.Command;

public class RcommentDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청게시판 댓글 삭제
		RboardService dao = new RboardServiceImpl();
		RcommentVO vo = new RboardVO();
		vo.setrCno(Integer.valueOf(request.getParameter("rcdel")));
		int n = dao.rcommentDelete(vo);
		String view = "";
		if (n != 0) {
			view = "rboardMain.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}

}
