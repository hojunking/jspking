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
		String sql="SELECT * FROM board";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo=new BoardVO();
				vo.setbId(rs.getInt("bid"));
				vo.setbTitle(rs.getString("btitle"));
				vo.setbWriter(rs.getString("bwriter"));
				vo.setbContent(rs.getString("bcontent"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
}
