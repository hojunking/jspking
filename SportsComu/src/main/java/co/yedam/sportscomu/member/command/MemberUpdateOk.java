package co.yedam.sportscomu.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;
import co.yedam.sportscomu.member.vo.MemberVO;

public class MemberUpdateOk implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setId(request.getParameter("id"));
		
		int n = dao.memberUpdate(vo);
		String page = "";
		String message = "회원정보 수정에 실패하였습니다.";
		if (n != 0) {
			page = "memberList.do";
		} else {
			request.setAttribute("message", message);
			page = "member/memberError";
		}
		
		return page;
	}

}
