package co.yedam.sportscomu.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.board.command.BoardList;
import co.yedam.sportscomu.board.command.DeleteBoard;
import co.yedam.sportscomu.board.command.DeleteBoardForm;
import co.yedam.sportscomu.board.command.InsertBoard;
import co.yedam.sportscomu.board.command.InsertBoardForm;
import co.yedam.sportscomu.board.command.SelectBoard;
import co.yedam.sportscomu.board.command.UpdateBoard;
import co.yedam.sportscomu.board.command.UpdateForm;
import co.yedam.sportscomu.command.Home;
import co.yedam.sportscomu.command.Login;
import co.yedam.sportscomu.command.Logout;
import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.command.CountEvent;
import co.yedam.sportscomu.event.command.DeleteEvent;
import co.yedam.sportscomu.event.command.DeleteEventForm;
import co.yedam.sportscomu.event.command.EventList;
import co.yedam.sportscomu.event.command.InsertEvent;
import co.yedam.sportscomu.event.command.InsertEventForm;
import co.yedam.sportscomu.member.command.MemberList;
import co.yedam.sportscomu.member.command.MemberSelect;
import co.yedam.sportscomu.member.command.MemberUpdate;
import co.yedam.sportscomu.member.command.MemberUpdateOk;
import co.yedam.sportscomu.sns.command.CommentsForm;
import co.yedam.sportscomu.sns.command.DeleteComments;
import co.yedam.sportscomu.sns.command.DeleteSns;
import co.yedam.sportscomu.sns.command.SearchSns;
import co.yedam.sportscomu.sns.command.SnsInsert;
import co.yedam.sportscomu.sns.command.SnsInsertForm;
import co.yedam.sportscomu.sns.command.SnsList;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home()); // 첫 화면으로
		
		map.put("/login.do", new Login());	// 로그인 후 화면 넘김
		map.put("/logout.do", new Logout());	// 로그아웃 기능 -> 로그인 화면으로
		map.put("/memberList.do", new MemberList());	// ADMIN 아이디로 로그인 시 회원 전체 목록 보기
		map.put("/memberSelect.do", new MemberSelect());	// 회원 전체 목록에서 1명 조회
		map.put("/memberUpdate.do", new MemberUpdate()); 	// 회원 정보 수정 화면으로
		map.put("/memberUpdateOk.do", new MemberUpdateOk());	// 회원 정보 수정 확인
		
		// 공지 사항 관련 부분
		map.put("/boardList.do", new BoardList());	// 공지사항 전체 조회
		map.put("/selectBoard.do", new SelectBoard());	// 공지사항 1건 조회
		map.put("/insertBoardForm.do", new InsertBoardForm());	// 새로 작성할 공지사항 폼으로 이동
		map.put("/insertBoard.do", new InsertBoard());	// 새 공지사항 등록
		map.put("/deleteBoardForm.do", new DeleteBoardForm()); // 공지사항 삭제 폼으로
		map.put("/deleteBoard.do", new DeleteBoard()); // 공지사항 삭제
		map.put("/updateForm.do", new UpdateForm());   // 공지사항 업데이트 폼으로
		map.put("/updateBoard.do", new UpdateBoard());	// 업데이트 수행
		
		// 게시글 관련 부분
		map.put("/snsList.do", new SnsList());	// 전체 게시글 출력
		map.put("/searchSns.do", new SearchSns());	// 게시글 1건 검색
		map.put("/snsInsertForm.do", new SnsInsertForm());	// 새 게시글 작성 폼으로
		map.put("/snsInsert.do", new SnsInsert());	// 새 게시글 작성
		map.put("/deleteSns.do", new DeleteSns());	// 게시글 삭제
		map.put("/deleteComments.do", new DeleteComments());	// 댓글 삭제
		map.put("/commentsForm.do", new CommentsForm());	// 댓글 등록
		
		// 단체 관람 관련 부분
		map.put("/eventList.do", new EventList());	// 단체관람 전체 목록보기
		map.put("/insertEventForm.do", new InsertEventForm());	// 단체관람 글쓰기 폼으로
		map.put("/insertEvent.do", new InsertEvent());	// 단체관람 글 추가
		map.put("/deleteEventForm.do", new DeleteEventForm());	// 단체관람 삭제 폼으로
		map.put("/deleteEvent.do", new DeleteEvent());	// 단체관람 목록 삭제
		map.put("/countEvent.do", new CountEvent());	// 카운터 
		
		
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if (!viewPage.endsWith(".do")) {	// Tiles를 태울거다 "home.do"
			if (!viewPage.endsWith(".jsp")) { 
				viewPage = viewPage + ".tiles";  // "home/home"
			} else { // Tiles를 안태울 거다!
				viewPage = "/WEB-INF/views/" +viewPage; // "home/home.jsp"
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
