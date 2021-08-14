package co.song.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.board.service.BoardService;
import co.song.prj.board.serviceImpl.BoardServiceImpl;
import co.song.prj.board.vo.SnsVO;
import co.song.prj.common.Command;

public class SnsBoard implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		BoardService dao= new BoardServiceImpl();
		SnsVO vo =new SnsVO();
		
		vo.setSNo(1);
		request.setAttribute("list", dao.snsSelect(vo));
		return "board/snsBoard";
	}
}
