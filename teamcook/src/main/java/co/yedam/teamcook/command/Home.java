package co.yedam.teamcook.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class Home implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		RecipeService recipeDao = new RecipeServiceImpl();
		
		List<RecipeVO> list = new ArrayList<RecipeVO>();
		list = recipeDao.recipeRecommendList();
		
		request.setAttribute("recipes", list);
		
		return "home/home";
	}

}
