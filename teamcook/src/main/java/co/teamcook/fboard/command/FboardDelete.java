package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class FboardDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 자유게시판 삭제
		FboardService dao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		vo.setfNo(Integer.valueOf(request.getParameter("fdel")));
		int n = dao.fboardDelete(vo);
		String view = "";
		if (n != 0) {
//			request.removeAttribute("fNo");
			view = "fboardMain.do";
		} else {
			view = "error.jsp";
		}

		return view;
	}

}
