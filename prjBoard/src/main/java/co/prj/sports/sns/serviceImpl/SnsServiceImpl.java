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
		String sql = "SELECT * FROM sns";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsAno(rs.getInt("sano"));
				vo.setsHit(rs.getInt("shit"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
	public List<SnsVO> snsSelect(int sNo) {
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo;
		String sql = "SELECT a.*,b.cname,b.csubject,b.cdate,b.cno FROM sns a left outer join comments b"
				+ " on(a.sno=b.sno) WHERE a.sno=?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new SnsVO();
				vo.setsNo(rs.getInt("sno"));
				vo.setsWriter(rs.getString("swriter"));
				vo.setsDate(rs.getDate("sdate"));
				vo.setsTitle(rs.getString("stitle"));
				vo.setsContents(rs.getString("scontents"));
				vo.setsAno(rs.getInt("sano"));
				vo.setsHit(rs.getInt("shit"));
				vo.setcName(rs.getString("cname"));
				vo.setcSubject(rs.getString("csubject"));
				vo.setcDate(rs.getDate("cdate"));
				vo.setcNo(rs.getInt("cNo"));
				sHitUpdate(vo.getsNo());
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
		String sql = "INSERT INTO sns(sno,swriter,sdate,stitle,scontents)" + "VALUES(s_seq.nextval,?,sysdate,?,?)";
		int n = 0;
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getsWriter());
			psmt.setString(2, vo.getsTitle());
			psmt.setString(3, vo.getsContents());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		String sql = "INSERT INTO comments(sno,cno,cname,csubject,cdate)" + "VALUES (?,c_seq.nextval,?,?,sysdate)";
		int n = 0;
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getsNo());
			psmt.setString(2, vo.getcName());
			psmt.setString(3, vo.getcSubject());
			n = psmt.executeUpdate();
			sAnoUpdate(vo.getsNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int snsDelete(SnsVO vo) {
		String sql ="DELETE FROM sns WHERE sno=?";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getsNo());
			n=psmt.executeUpdate();
			commentsDeleteAll(vo.getsNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		String sql="DELETE FROM comments WHERE cno=?";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.getcNo());
			n =psmt.executeUpdate();
			sAnoUpdatedown(vo.getsNo());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	@Override
	public void commentsDeleteAll(int sNo) {
		String sql="DELETE FROM comments WHERE sno=?";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		String sql="UPDATE sns SET stitle=?, scontents=? WHERE sno=?";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getsTitle());
			psmt.setString(2, vo.getsContents());
			psmt.setInt(3, vo.getsNo());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public void sHitUpdate(int sNo) {
		String sql = "UPDATE sns SET shit=shit+1 WHERE sno=?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void sAnoUpdate(int sNo) {
		String sql = "UPDATE sns SET sano=sano+1 WHERE sno=?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	@Override
	public void sAnoUpdatedown(int sNo) {
		String sql="UPDATE sns SET sano=sano-1 WHERE sno=?";
		try {
			conn= datasource.getConnection();
			psmt =conn.prepareStatement(sql);
			psmt.setInt(1, sNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}