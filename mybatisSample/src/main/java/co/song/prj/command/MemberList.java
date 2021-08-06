package co.song.prj.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.common.Command;
import co.song.prj.member.service.MemberService;
import co.song.prj.member.serviceImpl.MemberServiceImpl;
import co.song.prj.member.vo.MemberVO;

public class MemberList implements  Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService memberDao =new MemberServiceImpl();
		List<MemberVO> list= memberDao.memberSelectList();
		request.setAttribute("members", list);
		return "member/memberList";
	}
}
