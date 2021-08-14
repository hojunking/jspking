package co.yedam.teamcook.recipe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;

public class UpdateLike implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		RecipeService dao = new RecipeServiceImpl();
		int id=Integer.valueOf(request.getParameter("id"));
		
		dao.recipeLikeUpdate(id);
		request.setAttribute("rpid", id);
		//recipeSelect2 is used for update likeBtn 
		return "/recipeSelect2.do" ;
	}

}
