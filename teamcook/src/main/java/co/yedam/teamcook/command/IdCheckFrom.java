package co.yedam.teamcook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;

public class IdCheckFrom implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		request.setAttribute("checkId", request.getParameter("id"));
		return "home/idCheckFormJS.jsp";
	}

}
