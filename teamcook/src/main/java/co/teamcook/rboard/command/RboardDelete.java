package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class RboardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 요청게시판 삭제
		RboardService dao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		vo.setrNo(Integer.valueOf(request.getParameter("rdel")));
		int n = dao.rboardDelete(vo);
		String view = "";
		if (n != 0) {

			view = "rboardMain.do";
		} else {
			view = "home/error";
		}
		return view;
	}

}
