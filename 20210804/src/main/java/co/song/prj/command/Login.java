package co.song.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.common.Command;
import co.song.prj.member.service.MemberService;
import co.song.prj.member.serviceImpl.MemberServiceImpl;
import co.song.prj.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberService dao =new MemberServiceImpl();
		MemberVO vo =new MemberVO();
		
		vo.setId("song");
		vo.setPassword("1234");
		vo.setCheck("login");
		String check ="Login";
		request.setAttribute("member", dao.memberSelect(vo));
		return "member/loginResult";
	}

}
