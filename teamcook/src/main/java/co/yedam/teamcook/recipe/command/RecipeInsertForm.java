package co.yedam.teamcook.recipe.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.teamcook.common.Command;

public class RecipeInsertForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		return "recipe/recipeInsertForm";
	}

}
