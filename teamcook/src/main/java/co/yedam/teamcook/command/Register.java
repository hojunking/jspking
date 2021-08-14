package co.yedam.teamcook.command;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.member.service.MemberService;
import co.yedam.teamcook.member.serviceImpl.MemberServiceImpl;
import co.yedam.teamcook.member.vo.MemberVO;

public class Register implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao = new MemberServiceImpl();
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setEmail(request.getParameter("email"));
		
		int n = dao.memberInsert(vo);
		
		String path="";
		if(!(n==0)) {
			
			path="home/loginForm";
		}else {
			request.setAttribute("message", "Something went wrong");
			path="home/error";
		}
		
		
		return path;
	}

}
