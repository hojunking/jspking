package co.prj.sports.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.service.BoardService;
import co.prj.sports.board.serviceImpl.BoardServiceImpl;
import co.prj.sports.board.vo.BoardVO;

public class UpdateBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao = new BoardServiceImpl();
		BoardVO vo= new BoardVO();
		
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		vo.setbId(Integer.valueOf(request.getParameter("bId")));
		int n=dao.boardUpdate(vo);
		System.out.println(n + "스팟1");
		String path="";
		if(n !=0) {
			path="boardList.do";
		}else {
			path="main/boardError";
		}
		return path;
	}

}
