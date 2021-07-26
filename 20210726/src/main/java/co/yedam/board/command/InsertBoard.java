package co.yedam.board.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.board.vo.BoardVO;

public class InsertBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//string 값으로 변환하기
		BoardService dao= new BoardServiceImpl();
		BoardVO	vo= new BoardVO();
		vo.setbWriter(request.getParameter("bWriter"));
		vo.setbTitle(request.getParameter("bTitle"));
		vo.setbContent(request.getParameter("bContent"));
		System.out.println(vo+"스팟1");
//		vo.setbDate(Date.valueOf(request.getParameter("bDate")));
		int n =dao.boardInsert(vo);
		System.out.println(n +"2");
		String page="";
		if(n !=0) {
			page="boardList.do";
		}else {
			page="board/boardInsertFail";
		}
		return page;
	}

}
