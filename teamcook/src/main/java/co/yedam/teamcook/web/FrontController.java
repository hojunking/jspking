package co.yedam.teamcook.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.teamcook.fboard.command.FboardDelete;
import co.teamcook.fboard.command.FboardMain;
import co.teamcook.fboard.command.FboardUpdate;
import co.teamcook.fboard.command.FboardUpdateForm;
import co.teamcook.fboard.command.FcommentsDelete;
import co.teamcook.fboard.command.FcommentsDeleteForm;
import co.teamcook.fboard.command.FcommentsUpdate;
import co.teamcook.fboard.command.FcommentsUpdateForm;
import co.teamcook.fboard.command.InsertFboard;
import co.teamcook.fboard.command.InsertFboardForm;
import co.teamcook.fboard.command.InsertFcomments;
import co.teamcook.fboard.command.InsertFcommentsForm;
import co.teamcook.fboard.command.SearchFboard;
import co.teamcook.fboard.command.SearchFboard2;
import co.teamcook.rboard.command.InsertRboard;
import co.teamcook.rboard.command.InsertRboardForm;
import co.teamcook.rboard.command.InsertRcomment;
import co.teamcook.rboard.command.InsertRcommentForm;
import co.teamcook.rboard.command.RboardDelete;
import co.teamcook.rboard.command.RboardMain;
import co.teamcook.rboard.command.RboardUpdate;
import co.teamcook.rboard.command.RboardUpdateForm;
import co.teamcook.rboard.command.RcommentDelete;
import co.teamcook.rboard.command.RcommentDeleteForm;
import co.teamcook.rboard.command.RcommentUpdate;
import co.teamcook.rboard.command.RcommentUpdateForm;
import co.teamcook.rboard.command.SearchRboard;
import co.teamcook.rboard.command.UpdateRboard;
import co.yedam.teamcook.command.CheckId;
import co.yedam.teamcook.command.Home;
import co.yedam.teamcook.command.IdCheckFrom;
import co.yedam.teamcook.command.Login;
import co.yedam.teamcook.command.LoginForm;
import co.yedam.teamcook.command.Logout;
import co.yedam.teamcook.command.Register;
import co.yedam.teamcook.command.RegisterForm;
import co.yedam.teamcook.command.ToMyPage;
import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.command.AllRecipeList;
import co.yedam.teamcook.recipe.command.PhotoUpload;
import co.yedam.teamcook.recipe.command.RecipeInsert;
import co.yedam.teamcook.recipe.command.RecipeInsertForm;
import co.yedam.teamcook.recipe.command.RecipeSelect;
import co.yedam.teamcook.recipe.command.RecipeSelect2;
import co.yedam.teamcook.recipe.command.SearchRp;
import co.yedam.teamcook.recipe.command.UpdateLike;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     HashMap<String, Command> map = new HashMap<String, Command>();
   
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/home.do", new Home());
		map.put("/loginForm.do", new LoginForm());
		map.put("/login.do", new Login());
		
		//juyun part
		map.put("/recipeSelect.do", new RecipeSelect());
		//recipeSelect2 is used for update likeBtn 
		map.put("/recipeSelect2.do", new RecipeSelect2());
		map.put("/searchRp.do", new SearchRp());
		map.put("/registerForm.do", new RegisterForm());
		map.put("/register.do", new Register());
		map.put("/idCheckForm.do", new IdCheckFrom());
		map.put("/checkId.do", new CheckId());
		//map.put("MemberIdCheckAction.do", new MemberIdCheckAction());
		map.put("/allRecipeList.do", new AllRecipeList());
		map.put("/toMyPage.do", new ToMyPage());
		map.put("/updateLike.do", new UpdateLike());
		map.put("/logout.do", new Logout());
		map.put("/recipeInsertForm.do", new RecipeInsertForm());
		map.put("/recipeInsert.do", new RecipeInsert());
		map.put("/photoUpload.do", new PhotoUpload()); //레시피사진업로드
		
		
		//
		//
		//youjung part
		map.put("/fboardMain.do", new FboardMain()); // 유정0731
		map.put("/searchFboard.do", new SearchFboard());
		map.put("/searchFboard2.do", new SearchFboard2());
		map.put("/insertFboardForm.do", new InsertFboardForm());
		map.put("/insertFboard.do", new InsertFboard());
		map.put("/insertFcommentsForm.do", new InsertFcommentsForm());
		map.put("/insertFcomments.do", new InsertFcomments());
		map.put("/fboardUpdateForm.do", new FboardUpdateForm());
		map.put("/fboardUpdate.do", new FboardUpdate());
		map.put("/fboardDelete.do", new FboardDelete());
		map.put("/fcommentsUpdateForm.do", new FcommentsUpdateForm());
		map.put("/fcommentsUpdate.do", new FcommentsUpdate());
		map.put("/fcommentsDeleteForm.do", new FcommentsDeleteForm());
		map.put("/fcommentsDelete.do", new FcommentsDelete());

		map.put("/rboardMain.do", new RboardMain());
		map.put("/searchRboard.do", new SearchRboard());
		map.put("/insertRboardForm.do", new InsertRboardForm());
		map.put("/insertRboard.do", new InsertRboard());
		map.put("/insertRcommentForm.do", new InsertRcommentForm());
		map.put("/insertRcomment.do", new InsertRcomment());
		map.put("/rboardUpdateForm.do", new RboardUpdateForm());
		map.put("/rboardUpdate.do", new RboardUpdate());
		map.put("/rboardDelete.do", new RboardDelete());
		map.put("/rcommentUpdateForm.do", new RcommentUpdateForm());
		map.put("/rcommentUpdate.do", new RcommentUpdate());
		map.put("/rcommentDeleteForm.do", new RcommentDeleteForm());
		map.put("/rcommentDelete.do", new RcommentDelete());
		map.put("/updateRboard.do", new UpdateRboard());
		
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path=uri.substring(context.length());
		
		
		Command command = map.get(path);
		
		String viewPage = command.execute(request, response);
		
		
		if(viewPage !=null) {
			
			//ajax resolve...
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; cjarset=utf-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			
			//making view resolve..
			if(!viewPage.endsWith(".do")){ //home.do
				if(!viewPage.endsWith(".jsp")) { //use tiles
					viewPage = viewPage+".tiles"; //home/home
				}else { //타일즈 안태울거야
					viewPage = "/WEB-INF/views/"+viewPage; //home/home.jsp no tiles and use jsp
				}
			}
			
			
		}
		
		
		
		
		
//		if(viewPage.startsWith("tiles:")) {
//			viewPage = viewPage.substring(6)+".tiles";
//		}else if(!viewPage.endsWith(".do")){
//			viewPage = "/WEB-INF/views/"+viewPage+".jsp";
//		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	
	}

}
