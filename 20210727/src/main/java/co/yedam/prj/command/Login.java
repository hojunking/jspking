package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.prj.common.Command;
import co.yedam.prj.member.service.MemberService;
import co.yedam.prj.member.serviceImpl.MemberServiceImpl;
import co.yedam.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정을 처리하는 장소
		MemberService dao =new MemberServiceImpl();
		MemberVO vo =new MemberVO();
		HttpSession session =request.getSession(); //서버의 session 객체를 호출
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo =dao.memberLogin(vo);
		String page="";
		if(vo.getName() != null) { //세션에다가 담기 //.getName().isEmpty() ->값이 없느냐 null/값이 비어있느냐
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			page="member/loginSuccess";
		}else {
			String massage="존재하지 않는 아이디 또는 패스워드 입니다.";
			request.setAttribute("message", massage);
			page="member/memberError";
		}
		return page;
	}

}
