package co.song.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.song.prj.command.MemberList;
import co.song.prj.command.MemberSelect;
import co.song.prj.command.MemberSelectResult;
import co.song.prj.common.Command;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       HashMap<String, Command> map =new HashMap<String, Command>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/memberList.do", new MemberList());
		map.put("/memberSelect.do", new MemberSelect());
		map.put("/memberSelectResult.do", new MemberSelectResult());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //한글깨짐방지
		//실제 요청을 분석
		String uri = request.getRequestURI();
		String context= request.getContextPath();
		String path= uri.substring(context.length()); //실 요청 문 예)main.do
		
		Command command =map.get(path); //Command command =new Maincommand();
		String viewPage = command.execute(request, response); //실행될 결과를 보여줄 페이지
		
		if(!viewPage.endsWith(".do")) { //보여줄 페이지를 선택한다.
			viewPage ="WEB-INF/views/" +viewPage +".jsp";
		} 
		//!는 아닐때
		
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	
	
	}

}
