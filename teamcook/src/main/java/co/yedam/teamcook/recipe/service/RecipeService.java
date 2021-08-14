package co.yedam.teamcook.recipe.service;

import java.util.List;

import co.yedam.teamcook.recipe.vo.RecipeVO;

public interface RecipeService {
	List<RecipeVO> recipeSelectList();
	RecipeVO recipeSelect(RecipeVO vo);
	int recipeInsert(RecipeVO vo);
	int recipeDelete(RecipeVO vo);
	int recipeUpdate(RecipeVO vo);
	RecipeVO recipeSearch(RecipeVO vo); //search with search bar using keyword
	List<RecipeVO> recipeRecommendList(); //recommended list 
	int recipeLikeUpdate(int id); //update recipe like
	int rpImgInsert(RecipeVO vo); //upload img
}
