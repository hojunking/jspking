package co.yedam.Lms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String password =request.getParameter("password");

		request.setAttribute("id", id);
		request.setAttribute("password", password);
		return "main/home";
	}

}
