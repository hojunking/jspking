package co.yedam.sportscomu.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;
import co.yedam.sportscomu.member.vo.MemberVO;

public class SignUpCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setGender(request.getParameter("gender"));
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		int result = dao.memberInsert(vo);
		
		String page = "";
		String message = "회원가입 실패";
		if (result != 0) {
			page = "login/signUpCheck";
		} else {
			request.setAttribute("message", message);
			page = "login/error";
		}
		
		return page;
	}

}
