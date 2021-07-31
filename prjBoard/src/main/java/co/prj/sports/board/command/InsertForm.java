package co.prj.sports.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/insertForm";
	}

}
