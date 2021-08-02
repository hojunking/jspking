package co.prj.sports.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;

public class InsertEventForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		return "main/insertEventForm";
	}

}
