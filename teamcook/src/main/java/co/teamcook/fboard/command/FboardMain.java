package co.teamcook.fboard.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class FboardMain implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 자유게시판 첫 화면(메인화면 불러오기)
		FboardService fDao = new FboardServiceImpl();
		List<FboardVO> list = new ArrayList<FboardVO>();
		list = fDao.fboardSelectList();
		request.setAttribute("list", list);
		return "fboard/fboard";
	}
}
