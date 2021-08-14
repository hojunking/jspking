package co.teamcook.rboard.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class RboardUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 수정
		RboardService rDao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		int n = Integer.valueOf(request.getParameter("rnum"));
		vo = rDao.rboardSelect(n);
		request.setAttribute("upDateBoard", vo);
		return "rboard/updateRboardForm";
	}

}
