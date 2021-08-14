package co.yedam.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.Lms.board.service.BoardService;
import co.yedam.Lms.board.serviceImpl.BoardServiceImpl;
import co.yedam.Lms.board.vo.BoardVO;
import co.yedam.Lms.member.service.MemberService;
import co.yedam.Lms.member.serviceImpl.MemberServiceImpl;
import co.yedam.Lms.member.vo.MemberVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberService dao=new MemberServiceImpl();
		
		BoardService boardDao =new BoardServiceImpl(); //게시판 table
		
		MemberVO vo =new MemberVO();
		HttpSession session =request.getSession();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo =dao.memberLogin(vo);
		String page="";
		if(vo.getName()!=null) {
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			//session에 담아 놓으면 전역에서 사용가능?
			
			List<BoardVO> list=new ArrayList<BoardVO>();
			list=boardDao.boardSelectList();
			request.setAttribute("boards", list);
			
			page="main.do";
		}else {
			page="loginForm.do";
		}

		return page;
	}

}
