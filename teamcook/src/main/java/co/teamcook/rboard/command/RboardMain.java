package co.teamcook.rboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.serviceImpl.RboardServiceImpl;
import co.teamcook.rboard.vo.RboardVO;
import co.yedam.teamcook.common.Command;

public class RboardMain implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 건의게시판 첫 화면(메인게시판 리스트 불러오기)
		RboardService rDao = new RboardServiceImpl();
		List<RboardVO> list = new ArrayList<RboardVO>();
		list = rDao.rboardSelectList();
		request.setAttribute("list", list);
		return "rboard/rboardList";
	}

}
