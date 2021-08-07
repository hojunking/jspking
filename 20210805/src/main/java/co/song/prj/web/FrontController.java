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

import co.song.prj.comm.Command;
import co.song.prj.command.FileDownLoad;
import co.song.prj.command.FileList;
import co.song.prj.command.FileUpload;
import co.song.prj.command.FileUploadForm;
import co.song.prj.command.Home;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private HashMap<String, Command> map =new HashMap<String, Command>();
   
	   
     public FrontController() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	map.put("/home.do",new Home());
	map.put("/fileUpload.do",new FileUpload());
	map.put("/fileUploadForm.do",new FileUploadForm());
	map.put("/fileList.do",new FileList());
	map.put("/fileDownLoad.do",new FileDownLoad());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	String uri= request.getRequestURI();
	String context =request.getContextPath();
	String path=uri.substring(context.length());
	
	Command command = map.get(path);
	String viewPage= command.execute(request, response);
	
	if(!viewPage.endsWith(".do")) {
		viewPage = "WEB-INF/views/" + viewPage +".jsp";
		
	}
	RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	dispatcher.forward(request, response);
}
	}
