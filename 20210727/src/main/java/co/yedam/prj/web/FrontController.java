package co.yedam.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.prj.command.Home;
import co.yedam.prj.command.Login;
import co.yedam.prj.command.LoginForm;
import co.yedam.prj.command.Logout;
import co.yedam.prj.common.Command;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map =new HashMap<String, Command>();
    
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do",new Home());
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do",new Login());
		map.put("/logout.do", new Logout());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 분석,페이지
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		String contextPath =request.getContextPath();
		String path=uri.substring(contextPath.length());
		
		Command command = map.get(path);
		
		String viewPage =command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage="WEB-INF/views/" + viewPage +".jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
