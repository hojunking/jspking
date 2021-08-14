package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class InsertFboard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 새글작성
		FboardService dao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		vo.setfWriter(request.getParameter("fWriter"));
		System.out.println(request.getParameter("fWriter"));
		vo.setfTitle(request.getParameter("fTitle"));
		vo.setfContents(request.getParameter("fContents"));

		dao.fboardInsert(vo);
		return "fboardMain.do";
	}

}
