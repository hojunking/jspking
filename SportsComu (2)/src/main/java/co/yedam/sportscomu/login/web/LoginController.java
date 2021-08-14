package co.yedam.sportscomu.login.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.login.command.IdCheckForm;
import co.yedam.sportscomu.login.command.IdCheckPro;
import co.yedam.sportscomu.login.command.LoginForm;
import co.yedam.sportscomu.login.command.SignUpCheck;
import co.yedam.sportscomu.login.command.SignUpForm;



/**
 * Servlet implementation class LoginController
 */
@WebServlet("*.lo")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map.put("/loginForm.lo", new LoginForm());	// 로그인 폼으로 이동
		map.put("/signUpForm.lo", new SignUpForm());	// 회원강비 폼으로 이동
		map.put("/idCheckForm.lo", new IdCheckForm());	// 아이디 중복체크 화면 띄우기
		map.put("/idCheckPro.lo", new IdCheckPro());	// 아이디 중복체크 결과 확인
		map.put("/signUpCheck.lo", new SignUpCheck());	// 회원 가입 완료 확인
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		if (!viewPage.endsWith(".lo")) {
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
