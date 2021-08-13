package co.yedam.teamcook.recipe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class RecipeSelect2 implements Command {
//recipeSelect2 is used for update likeBtn
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		RecipeService dao = new RecipeServiceImpl();
		RecipeVO vo = new RecipeVO();
		
		
		Object sId=request.getAttribute("rpid");
		int iId= (int) sId;
		
		
		vo.setRpId(iId);
		vo=dao.recipeSelect(vo);
		request.setAttribute("recipe", vo);
		
		return "recipe/recipe";
	}

}
