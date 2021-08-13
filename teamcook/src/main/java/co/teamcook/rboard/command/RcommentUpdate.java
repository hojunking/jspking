package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RcommentVO;
import co.yedam.teamcook.common.Command;

public class RcommentUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청게시판 댓글 수정
		RboardService dao = new RboardServiceImpl();
		RcommentVO vo = new RcommentVO();
		vo.setrCno(Integer.valueOf(request.getParameter("rCno")));
		vo.setrcWriter(request.getParameter("rcWriter"));
		vo.setrcSubject(request.getParameter("rcSubject"));
		int n = dao.rcommentUpdate(vo);
		String view = "";
		if (n != 0) {
			request.setAttribute("rcomment", vo);
			view = "searchRboard.do";
		}
		return view;
	}

}
