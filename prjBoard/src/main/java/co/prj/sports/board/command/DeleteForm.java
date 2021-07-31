package co.prj.sports.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.service.BoardService;
import co.prj.sports.board.serviceImpl.BoardServiceImpl;
import co.prj.sports.board.vo.BoardVO;

public class DeleteForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao= new BoardServiceImpl();
		List<BoardVO> boards= new ArrayList<BoardVO>();
		boards=dao.boardSelectList();
		request.setAttribute("boards", boards);
		
		return "main/deleteForm";
	}

}
