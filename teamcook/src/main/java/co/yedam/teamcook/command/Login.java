package co.yedam.teamcook.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.member.service.MemberService;
import co.yedam.teamcook.member.serviceImpl.MemberServiceImpl;
import co.yedam.teamcook.member.vo.MemberVO;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class Login implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		MemberVO vo = new MemberVO();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		MemberService dao = new MemberServiceImpl();
		RecipeService recipeDao = new RecipeServiceImpl();
		HttpSession session = request.getSession();
		
		vo = dao.memberLogin(vo); 
		
		String path="";
		
		if(vo.getName() !=null) {
			//session setup
			session.setAttribute("session", vo);
			session.setAttribute("name", vo.getName());
			session.setAttribute("author", vo.getAuthor());
			session.setAttribute("id", vo.getId());
			
			//load recommended list
			List<RecipeVO> list = new ArrayList<RecipeVO>();
			list = recipeDao.recipeRecommendList();
			
			System.out.println(list);
			
			request.setAttribute("recipes", list);
			path="home/home";
		} else {
			request.setAttribute("message", "Id does not exist or wrong password");
			path="home/error";
		}
		
		
		return path;
	}

}
