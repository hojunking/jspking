package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class InsertRboard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새글 작성
		RboardService dao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		vo.setrTitle(request.getParameter("rTitle"));
		vo.setrWriter(request.getParameter("rWriter"));
		vo.setrContent(request.getParameter("rContent"));

		dao.rboardInsert(vo);
		return "rboardMain.do";
	}

}
