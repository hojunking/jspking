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

public class SearchFboard3 implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//댓글쓰기 눌렀다가 리스트로 돌아가기 
		// 선택된 글 호출
		FboardService fDao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		List<FcommentsVO> list = new ArrayList<FcommentsVO>();
		
		int n = Integer.parseInt((String) request.getAttribute("fNo"));
		vo = fDao.fboardSelect(n);
		
	
		list = fDao.fcommentsSelectList(vo.getfNo());
		
		//juyun edited--02082021
		request.setAttribute("selectedMain", vo);
	
		request.setAttribute("selectComments", list);
	
		return "fboard/fboardReply";
	}

}
