package co.yedam.sportscomu.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.board.service.BoardService;
import co.yedam.sportscomu.board.serviceImpl.BoardServiceImpl;
import co.yedam.sportscomu.board.vo.BoardVO;
import co.yedam.sportscomu.common.Command;

public class DeleteBoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardService dao= new BoardServiceImpl();
		List<BoardVO> boards= new ArrayList<BoardVO>();
		boards=dao.boardSelectList();
		request.setAttribute("boards", boards);
		
		return "board/deleteBoardForm";
	}

}
