package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class InsertFcommentsForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 댓글 작성 폼
		FboardService fDao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		int n = Integer.valueOf(request.getParameter("fNo"));
		vo = fDao.fboardSelect(n);
		 request.setAttribute("insertComment", vo);
		return "fboard/insertFcommentsForm";
	}

}
