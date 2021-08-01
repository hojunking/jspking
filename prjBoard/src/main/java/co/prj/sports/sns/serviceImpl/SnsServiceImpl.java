package co.prj.sports.sns.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.prj.sports.board.dao.DataSource;
import co.prj.sports.comments.vo.CommentsVO;
import co.prj.sports.sns.service.SnsService;
import co.prj.sports.sns.vo.SnsVO;

public class SnsServiceImpl implements SnsService {
	private DataSource datasource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<SnsVO> snsSelectList() {
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql ="SELECT * FROM sns";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo =new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

	private void close() {
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<SnsVO> snsSelect(int no) {
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "SELECT a.*,b.cname,b.csubject,b.cdate FROM sns a left outer join comments b"
				+ " on(a.sno=b.sno) WHERE a.sno=?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsContents(rs.getString("scontents"));
				vo.setsAno(rs.getInt("sano"));
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("csubject"));
				vo.setcDate(rs.getDate("cdate"));
				list.add(vo);
			}
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}


	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
