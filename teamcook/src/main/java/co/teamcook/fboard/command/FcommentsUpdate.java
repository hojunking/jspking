package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.serviceImpl.FboardServiceImpl;
import co.teamcook.fboard.vo.FcommentsVO;
import co.yedam.teamcook.common.Command;

public class FcommentsUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 자유게시판 댓글 수정
		FboardService dao = new FboardServiceImpl();
		FcommentsVO vo = new FcommentsVO();
		
		vo.setfNo(Integer.valueOf(request.getParameter("currentMainNo")));
		vo.setfCno(Integer.valueOf(request.getParameter("fCno")));
		vo.setfcSubject(request.getParameter("fcSubject"));
		
		int n = dao.fcommentsUpdate(vo);
		String view = "";
		
		if (n != 0) {			
			request.setAttribute("fNo", vo.getfNo());
			view = "searchFboard3.do";
		} else {
			request.setAttribute("message", "오류가 발생했습니다. 다시 시도해 주세요.");
			view = "home/error";
		}
		return view;
	}

}
//업데이트를 해서 vo 객체에 넣어서 그걸 땡겨온다.