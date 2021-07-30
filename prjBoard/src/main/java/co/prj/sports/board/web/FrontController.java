package co.prj.sports.board.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.board.command.HomeCommand;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      private HashMap<String, Command> map= new HashMap<String, Command>();
      
    public FrontController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	map.put("/home.do", new HomeCommand());
	map.put("/boardList.do", new BoardList());
	
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String context=request.getContextPath();
		String page=uri.substring(context.length());
		
		Command command =map.get(page);
		String viewPage=command.execute(request, response);
		
		if(!viewPage.endsWith(".do")) {
			viewPage="WEB-INF/views/"+viewPage+".jsp";
		}
		RequestDispatcher dispatcher =request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
