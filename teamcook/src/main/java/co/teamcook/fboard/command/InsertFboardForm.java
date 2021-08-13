package co.teamcook.fboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;

public class InsertFboardForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 글 작성 화면
		return "fboard/insertFboardForm";
	}

}
