package co.yedam.teamcook.recipe.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class AllRecipeList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RecipeService dao = new RecipeServiceImpl();
		
		List<RecipeVO> recipes = new ArrayList<RecipeVO>();
		recipes = dao.recipeSelectList();
		
		request.setAttribute("list", recipes);
		
		return "recipe/recipeList";
		
	}

}
