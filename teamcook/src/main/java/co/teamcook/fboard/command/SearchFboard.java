package co.teamcook.fboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.teamcook.fboard.vo.FcommentsVO;
import co.yedam.teamcook.common.Command;

public class SearchFboard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 선택된 글 호출
		FboardService fDao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		List<FcommentsVO> list = new ArrayList<FcommentsVO>();
		
		int n = Integer.parseInt(request.getParameter("fNo"));
		vo = fDao.fboardSelect(n);
		
	
		list = fDao.fcommentsSelectList(vo.getfNo());
		
		
		request.setAttribute("selectBoard", vo);
	
		request.setAttribute("selectComments", list);
	
		return "fboard/fboardReply";
	}

}
