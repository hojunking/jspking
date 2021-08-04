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

import co.song.prj.command.CommandHome;
import co.song.prj.command.Login;
import co.song.prj.command.MemberSearch;
import co.song.prj.command.SnsBoard;
import co.song.prj.command.SnsList;
import co.song.prj.common.Command;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private HashMap<String, Command> map =new HashMap<String, Command>();
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	map.put("/home.do", new CommandHome());
	map.put("/snsList.do",new SnsList());
	map.put("/snsBoard.do",new SnsBoard());
	map.put("/login.do", new Login());
	map.put("/memberSearch.do", new MemberSearch());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri=request.getRequestURI();
		String context =request.getContextPath();
		String page=uri.substring(context.length());
		
		Command command =map.get(page);
		
		String viewPage =command.execute(request, response);
		if(!viewPage.endsWith(".do")) {
			viewPage = "WEB-INF/views/"+viewPage+".jsp";
			
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		}
	
	
	}

}
