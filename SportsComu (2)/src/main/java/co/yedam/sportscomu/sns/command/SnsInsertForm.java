package co.yedam.sportscomu.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;

public class SnsInsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 새 게시글 작성 폼으로
		return "sns/snsInsertForm";
	}

}
