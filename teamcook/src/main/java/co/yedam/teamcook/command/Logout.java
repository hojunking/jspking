package co.yedam.teamcook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.teamcook.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();

		session.removeAttribute("id");
		session.removeAttribute("name");
		session.removeAttribute("author");
		
		session.invalidate();
		
		return "/loginForm.do";
	}

}
