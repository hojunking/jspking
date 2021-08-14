package co.yedam.sportscomu.member.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.member.service.MemberService;
import co.yedam.sportscomu.member.serviceImpl.MemberServiceImpl;
import co.yedam.sportscomu.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 전체 목록
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.memberSelectAll();
		request.setAttribute("list", list);
		return "member/memberList";
	}

}
