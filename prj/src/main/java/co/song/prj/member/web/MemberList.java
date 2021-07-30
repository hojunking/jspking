package co.song.prj.member.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.common.Command;
import co.song.prj.member.service.MemberService;
import co.song.prj.member.serviceImpl.MemberServiceImpl;
import co.song.prj.member.vo.MemberVO;

public class MemberList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao = new MemberServiceImpl();
		List<MemberVO> list =dao.memberSelectList();
		System.out.println(list);
		request.setAttribute("list", list);
		return "main/memberList";
	}

}
