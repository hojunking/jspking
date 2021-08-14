package co.yedam.teamcook.recipe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.serviceImpl.RecipeServiceImpl;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class RecipeInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
RecipeService dao = new RecipeServiceImpl();
		
		RecipeVO vo = new RecipeVO();
		
		vo.setRpTitle(request.getParameter("rptitle"));
		vo.setRpIn(request.getParameter("rpin"));
		vo.setRpDiet(request.getParameter("rpdiet"));
		vo.setRpMethod(request.getParameter("rpmethod"));
		vo.setRpRecommend(request.getParameter("rprecommend"));
		String path="";
		int n = dao.recipeInsert(vo);
		if(n != 0) {
			request.setAttribute("rptitle", vo.getRpTitle());
			request.setAttribute("message", "Recipe Inserted. Do you want to upload a photo?");
			path="recipe/recipePhotoInsertForm";
		}else {
			request.setAttribute("message", "Recipe Insert Failed! Try again!!");
			path="home/error";
		}
		//레시피인풋 페이지로 다시 돌아가기
		return path;
		
	}

}
