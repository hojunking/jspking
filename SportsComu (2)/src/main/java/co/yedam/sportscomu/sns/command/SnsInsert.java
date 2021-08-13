package co.yedam.sportscomu.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.sns.service.SnsService;
import co.yedam.sportscomu.sns.serviceImpl.SnsServiceImpl;
import co.yedam.sportscomu.sns.vo.SnsVO;

public class SnsInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 새 게시글 작성
		SnsService dao= new SnsServiceImpl();
		SnsVO vo=new SnsVO();
		vo.setsTitle(request.getParameter("sTitle"));
		vo.setsContents(request.getParameter("sContents"));
		vo.setsWriter(request.getParameter("sWriter"));
		int n= dao.snsInsert(vo);
		
		String page="";
		if(n != 0) {
			page="snsList.do";
		}else {
			page="board/boardError";
		}
		return page;
	}
}
