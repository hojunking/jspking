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

import co.song.prj.command.HomeCommand;
import co.song.prj.command.loginform;
import co.song.prj.common.Command;
import co.song.prj.member.web.MemberList;

@WebServlet("*.do")
public class WebController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    public WebController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/home.do", new HomeCommand());
		map.put("/loginForm.do", new loginform());
		map.put("/memberList.do", new MemberList());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String context= request.getContextPath();
		String page=uri.substring(context.length());
		
		Command command =map.get(page);
		String viewpage=command.execute(request, response);
		
		if(!viewpage.endsWith(".do")) {
			viewpage="WEB-INF/views/" + viewpage +".jsp";
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewpage);
		dispatcher.forward(request, response);
	}

}
