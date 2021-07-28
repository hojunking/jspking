package co.yedam.Lms.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		HttpSession session=request.getSession();
		session.invalidate();
		return "login.do";
	}

}
