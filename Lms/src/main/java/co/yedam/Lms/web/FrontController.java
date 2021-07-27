package co.yedam.Lms.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.Lms.command.Command;
import co.yedam.Lms.command.Login;
import co.yedam.Lms.command.LoginForm;
import co.yedam.Lms.command.Main;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map =new HashMap<String, Command>();
    
    
    public FrontController() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	map.put("/main.do", new Main());
	map.put("/loginForm.do", new LoginForm());
	map.put("/login.do",new Login());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		String contextPath =request.getContextPath();
		String page=uri.substring(contextPath.length());
		
		Command command =map.get(page);
		String viewPage =command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage="WEB-INF/views/" +viewPage +".jsp";
			
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
