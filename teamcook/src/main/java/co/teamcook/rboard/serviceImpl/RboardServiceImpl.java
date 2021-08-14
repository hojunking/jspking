package co.teamcook.rboard.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.teamcook.rboard.service.RboardService;
import co.teamcook.rboard.vo.RboardVO;
import co.teamcook.rboard.vo.RcommentVO;
import co.yedam.teamcook.dao.DataSource;

public class RboardServiceImpl implements RboardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<RboardVO> rboardSelectList() {
		// 건의게시판 글 목록 조회
		List<RboardVO> list = new ArrayList<RboardVO>();
		RboardVO vo;
		String sql = "select * from rboard";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new RboardVO();
				vo.setrNo(rs.getInt("rno"));
				vo.setrWriter(rs.getString("rwriter"));
				vo.setrDate(rs.getDate("rdate"));
				vo.setrTitle(rs.getString("rtitle"));
				vo.setrContent(rs.getString("rcontent"));
				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	@Override
	   public RboardVO rboardSelect(int rno) {
	      // 게시글 선택하면 댓글을 포함해서 조회
	      RboardVO vo = null;
	      String sql = "select a.*, b.rcwriter, b.rcsubject, b.rcdate from rboard a left outer join rcomment b on (a.rno = b.rno) where a.rno = ?";
	      try {
	         conn = dataSource.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, rno);
	         rs = psmt.executeQuery();
	         if (rs.next()) {
	            vo = new RboardVO();
	            vo.setrNo(rs.getInt("rno"));
	            vo.setrWriter(rs.getString("rwriter"));
	            vo.setrDate(rs.getDate("rdate"));
	            vo.setrTitle(rs.getString("rtitle"));
	            vo.setrContent(rs.getString("rcontent"));
	            vo.setrcWriter(rs.getString("rcwriter"));
	            vo.setrcSubject(rs.getString("rcsubject"));
	            vo.setrcDate(rs.getDate("rcdate"));

	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      System.out.println("rboaed iml select ");
	      System.out.println(vo);
	      return vo;
	   }



	private void rCnoUpdate(int rNo) {
		// 조회수 증가
		String sql = "update rboard set rcno = rcno + 1 where rno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int rboardInsert(RboardVO vo) {
		// 글추가
		String sql = "insert into rboard (rno, rwriter, rdate, rtitle, rcontent) values(r_seq.nextval, ?, sysdate, ?, ?)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getrWriter());
			psmt.setString(2, vo.getrTitle());
			psmt.setString(3, vo.getrContent());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int rboardDelete(RboardVO vo) {
		// 글삭제
		int n = 0;
		String sql = "delete from rboard where rno = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getrNo());
			n = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int rboardUpdate(RboardVO vo) {
		// 글 수정
		int n = 0;
		String sql = "update rboard set rtitle = ?, rcontent = ? where rno = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getrTitle());
			psmt.setString(2, vo.getrContent());
			psmt.setInt(3, vo.getrNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int rcommentInsert(RcommentVO vo) {
		// 댓글 추가
		String sql = "insert into rcomment values(?, rc_seq.nextval, ?, ?, sysdate)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getrCno());
			psmt.setString(2, vo.getrcWriter());
			psmt.setString(3, vo.getrcSubject());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int rcommentDelete(RcommentVO vo) {
		// 댓글 삭제
		int n = 0;
		String sql = "delete from rcomment where rcno = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getrCno());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int rcommentUpdate(RcommentVO vo) {
		// 댓글 수정
		int n = 0;
		String sql = "update rcomment set rcsubject = ? where rcwriter = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getrcSubject());
			psmt.setString(2, vo.getrcWriter());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	   @Override
	   public List<RcommentVO> rcommentsSelectList(int rNo) {
	      // 댓글 리스트
	      List<RcommentVO> list = new ArrayList<RcommentVO>();
	      int originalArticleNo = rNo;
	      String sql = "select * from rcomment where rno = ?";
	      RcommentVO rvo;
	      try {
	         conn = dataSource.getConnection();
	         psmt = conn.prepareStatement(sql);
	         psmt.setInt(1, originalArticleNo);
	         rs = psmt.executeQuery();
	         while (rs.next()) {
	            rvo = new RcommentVO();
	            rvo.setrNo(rs.getInt("rno"));
	            rvo.setrCno(rs.getInt("rcno"));
	            rvo.setrcWriter(rs.getString("rcwriter"));
	            rvo.setrcSubject(rs.getString("rcsubject"));
	            rvo.setrcDate(rs.getDate("rcdate"));
	            list.add(rvo);
	         }
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return list;
	   }

}
