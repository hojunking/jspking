package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FboardVO;
import co.yedam.teamcook.common.Command;

public class FboardUpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 메인글 수정
		FboardService fDao = new FboardServiceImpl();
		FboardVO vo = new FboardVO();
		System.out.println(request.getParameter("fnum"));
		int n = Integer.valueOf(request.getParameter("fnum"));
		vo = fDao.fboardSelect(n);
		request.setAttribute("upDateBoard", vo);
		// 여기서 게시글 셀렉트 하고
		// 그걸 리퀘스트.셋 어트리뷰트 해서 리스트 
		return "fboard/updateFboardForm";
	}

}
