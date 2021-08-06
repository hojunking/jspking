package co.yedam.sportscomu.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.board.service.BoardService;
import co.yedam.sportscomu.board.serviceImpl.BoardServiceImpl;
import co.yedam.sportscomu.board.vo.BoardVO;
import co.yedam.sportscomu.common.Command;

public class BoardList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 전체 리스트
		BoardService dao= new BoardServiceImpl();
		List<BoardVO> boards= new ArrayList<BoardVO>();
		boards = dao.boardSelectList();
		request.setAttribute("boards", boards);
		
		return "board/boardList";
	}

}
