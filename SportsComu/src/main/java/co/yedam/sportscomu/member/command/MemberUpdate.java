package co.yedam.sportscomu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;
import co.yedam.sportscomu.member.vo.MemberVO;

public class MemberUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo = dao.memberSelectOne(vo);
		
		request.setAttribute("member", vo);
		return "member/memberUpdate";
	}

}
