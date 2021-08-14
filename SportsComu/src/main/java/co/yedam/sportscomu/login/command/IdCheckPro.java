package co.yedam.sportscomu.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;

public class IdCheckPro implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복체크 확인!
		MemberService dao = new MemberServiceImpl();
		String id = request.getParameter("id");
		int result = dao.checkId(id);
		
		request.setAttribute("cnt", result);
		return "login/idCheckPro";
	}

}
