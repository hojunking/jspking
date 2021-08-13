package co.yedam.teamcook.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.member.service.MemberService;
import co.yedam.teamcook.member.serviceImpl.MemberServiceImpl;
import co.yedam.teamcook.member.vo.MemberVO;

public class CheckId implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();

		vo.setId(request.getParameter("checkId"));
		int n=dao.memberIdCheck(vo);
		
		if(n == 1 ) {
			request.setAttribute("message", "이 아이디는 이미 사용중입니다.");
		}else {
			request.setAttribute("message", "이 아이디는 사용가능합니다.");
		}
		return "home/idCheckResult.jsp";
	}

}
