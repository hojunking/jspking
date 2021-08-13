package co.yedam.teamcook.recipe.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.teamcook.dao.DataSource;
import co.yedam.teamcook.recipe.service.RecipeService;
import co.yedam.teamcook.recipe.vo.RecipeVO;

public class RecipeServiceImpl implements RecipeService {

	private DataSource dataSource;
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<RecipeVO> recipeSelectList() {
		// TODO Auto-generated method stub
		List<RecipeVO> list = new ArrayList<RecipeVO>();
		RecipeVO vo;
		String sql = "select * from recipe";
		
		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new RecipeVO();
				vo.setRpId(rs.getInt("rpid"));
				vo.setRpTitle(rs.getString("rptitle"));
				vo.setRpIn(rs.getString("rpin"));
				vo.setRpDiet(rs.getString("rpdiet"));
				vo.setRpMethod(rs.getString("rpmethod"));
				vo.setRpLikes(rs.getInt("rplikes"));
				vo.setRpDate(rs.getDate("rpdate"));
				vo.setRpRecommend(rs.getString("rprecommend"));
				vo.setRpImg(rs.getString("rpimg"));

				list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return list;
	}

	@Override
	public RecipeVO recipeSelect(RecipeVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from recipe where rpid=?";
		
		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getRpId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setRpId(rs.getInt("rpid"));
				vo.setRpTitle(rs.getString("rptitle"));
				vo.setRpIn(rs.getString("rpin"));
				vo.setRpDiet(rs.getString("rpdiet"));
				vo.setRpMethod(rs.getString("rpmethod"));
				vo.setRpLikes(rs.getInt("rplikes"));
				vo.setRpDate(rs.getDate("rpdate"));
				vo.setRpRecommend(rs.getString("rprecommend"));
				vo.setRpImg(rs.getString("rpimg"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
		
	}
	
	@Override
	public RecipeVO recipeSearch(RecipeVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from recipe where rptitle like '%' || ? || '%' ";
		
		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getRpTitle());
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setRpId(rs.getInt("rpid"));
				vo.setRpTitle(rs.getString("rptitle"));
				vo.setRpIn(rs.getString("rpin"));
				vo.setRpDiet(rs.getString("rpdiet"));
				vo.setRpMethod(rs.getString("rpmethod"));
				vo.setRpLikes(rs.getInt("rplikes"));
				vo.setRpDate(rs.getDate("rpdate"));
				vo.setRpRecommend(rs.getString("rprecommend"));
				vo.setRpImg(rs.getString("rpimg"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	
	}


	@Override
	public List<RecipeVO> recipeRecommendList() {
		// TODO Auto-generated method stub
		List<RecipeVO> list = new ArrayList<RecipeVO>();
		RecipeVO vo;
		String sql = "select * from recipe where RPRECOMMEND='yes'";
		
		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new RecipeVO();
				vo.setRpId(rs.getInt("rpid"));
				vo.setRpTitle(rs.getString("rptitle"));
				vo.setRpIn(rs.getString("rpin"));
				vo.setRpDiet(rs.getString("rpdiet"));
				vo.setRpMethod(rs.getString("rpmethod"));
				vo.setRpLikes(rs.getInt("rplikes"));
				vo.setRpDate(rs.getDate("rpdate"));
				vo.setRpRecommend(rs.getString("rprecommend"));
				vo.setRpImg(rs.getString("rpimg"));
				
				list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}

		return list;
	}
	
	
	@Override
	public int recipeLikeUpdate(int id) {
		// TODO Auto-generated method stub
String sql = "update recipe set rplikes = rplikes+1 where rpid=?";
		
		dataSource = DataSource.getInstance();
		int n=0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,id);
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int rpImgInsert(RecipeVO vo) {
		// TODO Auto-generated method stub
	String sql = "update recipe set rpimg=? where rptitle=?";
		
		dataSource = DataSource.getInstance();
		int n=0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getRpImg());
			psmt.setString(2, vo.getRpTitle());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	@Override
	public int recipeInsert(RecipeVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into recipe values(p_seq.nextval,?,?,?,?, 0, sysdate, ?, null)";
		
		dataSource = DataSource.getInstance();
		int n=0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getRpTitle());
			psmt.setString(2, vo.getRpIn());
			psmt.setString(3, vo.getRpDiet());
			psmt.setString(4, vo.getRpMethod());
			psmt.setString(5, vo.getRpRecommend());
			n = psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int recipeDelete(RecipeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int recipeUpdate(RecipeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	






}
