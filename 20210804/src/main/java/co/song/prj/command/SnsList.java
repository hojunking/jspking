package co.song.prj.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.board.service.BoardService;
import co.song.prj.board.serviceImpl.BoardServiceImpl;
import co.song.prj.common.Command;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 목록가져오기
		BoardService boardDao=new BoardServiceImpl();
//		List<SnsVO> vo=new ArrayList<SnsVO>();
//		vo=boardDao.snsSelectList();
		
		
		request.setAttribute("lists", boardDao.snsSelectList());
		return "board/snsList";
	}

}
