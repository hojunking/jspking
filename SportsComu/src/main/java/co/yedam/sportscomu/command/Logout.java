package co.yedam.sportscomu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.sportscomu.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃
		HttpSession session = request.getSession();
		session.invalidate();	// 세션 삭제
		return "login/loginForm.jsp";
	}

}
