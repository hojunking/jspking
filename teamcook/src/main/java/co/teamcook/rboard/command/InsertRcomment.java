package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RcommentVO;
import co.yedam.teamcook.common.Command;

public class InsertRcomment implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새 댓글 작성
		RboardService dao = new RboardServiceImpl();
		RcommentVO vo = new RcommentVO();
		vo.setrCno(Integer.valueOf(request.getParameter("rNo")));
		vo.setrcWriter(request.getParameter("rcWriter"));
		vo.setrcSubject(request.getParameter("rcSubject"));

		int n = dao.rcommentInsert(vo);
		System.out.println(n +"ddd");
		String view = "";
		if (n != 0) {
			request.setAttribute("rNo", vo.getrCno());
			view = "searchRboard.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}
}
