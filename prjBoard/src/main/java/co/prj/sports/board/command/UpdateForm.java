package co.prj.sports.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.service.BoardService;
import co.prj.sports.board.serviceImpl.BoardServiceImpl;
import co.prj.sports.board.vo.BoardVO;

public class UpdateForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao= new BoardServiceImpl();
		BoardVO  vo= new BoardVO();
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		vo=dao.boardSelect(vo);
		request.setAttribute("boards", vo);
		
		return "main/updateForm";
	}

}
