package co.teamcook.rboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;

public class RcommentDeleteForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 댓글 삭제
		return "rboard/deleteRcommentForm";
	}

}
