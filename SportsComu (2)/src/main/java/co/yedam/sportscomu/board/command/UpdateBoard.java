package co.yedam.sportscomu.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.board.service.BoardService;
import co.yedam.sportscomu.board.serviceImpl.BoardServiceImpl;
import co.yedam.sportscomu.board.vo.BoardVO;
import co.yedam.sportscomu.common.Command;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardService dao = new BoardServiceImpl();
		BoardVO vo= new BoardVO();
		
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n=dao.boardUpdate(vo);
		
		String page="";
		if(n !=0) {
			page="boardList.do";
		}else {
			page="board/boardError";
		}
		return page;
	}

}
