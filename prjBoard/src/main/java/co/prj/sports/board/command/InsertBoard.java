package co.prj.sports.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.service.BoardService;
import co.prj.sports.board.serviceImpl.BoardServiceImpl;
import co.prj.sports.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao=new BoardServiceImpl();
		BoardVO vo= new BoardVO();
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbWriter(request.getParameter("bWriter"));
		int n=dao.boardInsert(vo);
		String path="";
		if(n != 0) {
			path="boardList.do";
		}else {
			path="main/boardError";
		}
		
		return path;
	}

}
