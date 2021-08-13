package co.teamcook.rboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.teamcook.rboard.vo.RcommentVO;
import co.yedam.teamcook.common.Command;

public class SearchRboard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 선택된 글 호출
		RboardService rDao = new RboardServiceImpl();
		RboardVO vo = new RboardVO();
		List<RcommentVO> list = new ArrayList<RcommentVO>();
		int n = Integer.valueOf(request.getParameter("rNo"));
		vo = rDao.rboardSelect(n);

		list = rDao.rcommentsSelectList(vo.getrNo());
		
		
		request.setAttribute("selectBoard", vo);
		request.setAttribute("selectComment", list);
		return "rboard/rboardReply";
	   }


}
