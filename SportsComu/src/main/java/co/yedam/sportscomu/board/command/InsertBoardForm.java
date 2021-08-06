package co.yedam.sportscomu.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;

public class InsertBoardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 새로 작성할 form으로 이동
		return "board/insertBoardForm";
	}

}
