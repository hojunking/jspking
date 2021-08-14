package co.yedam.sportscomu.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.board.service.BoardService;
import co.yedam.sportscomu.board.serviceImpl.BoardServiceImpl;
import co.yedam.sportscomu.board.vo.BoardVO;
import co.yedam.sportscomu.common.Command;

public class DeleteBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 삭제
		BoardService dao=new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n= dao.boardDelete(vo);
		String page="";
		if(n !=0) {
			page="deleteBoardForm.do";
		}else {
			page="board/boardError";
		}
		return page;
	}

}
