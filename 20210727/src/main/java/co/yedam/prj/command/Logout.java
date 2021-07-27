package co.yedam.prj.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.prj.common.Command;

public class Logout implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그아웃
		HttpSession session =request.getSession();
		System.out.println(session.getId()+"================"); //sid에 따른 session값 부여
		String message= session.getAttribute("name")+"님 정상로그 아웃 되셨습니다.";
//		session.invalidate();
		session.removeAttribute("name");
		session.removeAttribute("author");
		//invalidate-> session 그 자체 다 삭제 , remove는 그 안에 값을 다 지움
		request.setAttribute("message", message);
		return "member/memberError";
	}

}
