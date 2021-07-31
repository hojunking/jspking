package co.prj.sports.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.prj.sports.board.dao.DataSource;
import co.prj.sports.board.service.BoardService;
import co.prj.sports.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	private DataSource datasource =DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<BoardVO> boardSelectList() {
		List<BoardVO> list =new ArrayList<BoardVO>();
		BoardVO vo;
		String sql="SELECT * FROM board ORDER BY bDate DESC";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo=new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}


	@Override
	public BoardVO boardSelect(BoardVO vo) {
		String sql="SELECT * FROM board WHERE bid=?";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			rs=psmt.executeQuery();
			if(rs.next()) {
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbContent(rs.getString("bcontent"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbDate(rs.getDate("bdate"));
				vo.setbHit(rs.getInt("bhit"));
				hitUpdate(vo.getbId());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		String sql ="UPDATE board SET btitle=?, bcontent=?, bdate=sysdate,bhit=0 WHERE bid=?" ;
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setInt(3, vo.getbId());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return n;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		String sql ="DELETE FROM board WHERE bid=?";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getbId());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		String sql="INSERT INTO board(bid, btitle, bcontent,"
		+"bwriter, bdate) VALUES(b_SEQ.NEXTVAL,?,?,?,sysdate)";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getbTitle());
			psmt.setString(2, vo.getbContent());
			psmt.setString(3, vo.getbWriter());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	private void close() {
		try {
			if(rs!=null) {rs.close();}
			if(psmt !=null) {psmt.close();}
			if(conn !=null) {conn.close();}
		} catch ( SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void hitUpdate(int id) {
		String sql="UPDATE board SET bhit = bhit+1 WHERE bid=?";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
