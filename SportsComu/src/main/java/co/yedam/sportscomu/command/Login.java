package co.yedam.sportscomu.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;
import co.yedam.sportscomu.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 후
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		// 서버가 가지고 있는 세션 객체를 호출
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		
		String page = "";
		if (vo.getName() != null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("id", vo.getId());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("session", vo);
			page = "home/home";
		} else {
			String message = "존재하지 않는 아이디 혹은 비밀번호가 틀렸습니다.";
			request.setAttribute("message", message);
			page = "home/loginError.jsp";
		}
		return page;
	}

}
