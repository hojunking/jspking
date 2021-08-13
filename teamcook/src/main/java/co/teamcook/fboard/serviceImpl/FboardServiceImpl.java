package co.teamcook.fboard.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.teamcook.fboard.service.FboardService;
import co.teamcook.fboard.vo.FboardVO;
import co.teamcook.fboard.vo.FcommentsVO;
import co.yedam.teamcook.dao.DataSource;

public class FboardServiceImpl implements FboardService {
	private DataSource dataSource = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	@Override
	public List<FboardVO> fboardSelectList() {
		// 자유게시판에 글목록 조회
		List<FboardVO> list = new ArrayList<FboardVO>();
		FboardVO vo;
		String sql = "select * from fboard";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new FboardVO();
				vo.setfNo(rs.getInt("fno"));
				vo.setfWriter(rs.getString("fwriter"));
				vo.setfTitle(rs.getString("ftitle"));
				vo.setfDate(rs.getDate("fdate"));
				vo.setfContents(rs.getString("fcontents"));
				vo.setfHit(rs.getInt("fhit"));
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
	public FboardVO fboardSelect(int fno) {
		// 게시글 선택하면 댓글을 포함해서 조회
		FboardVO vo = null;
		String sql = "select a.*, b.fcname, b.fcsubject, b.fcdate from fboard a left outer join fcomments b on (a.fno = b.fno) where a.fno = ? ";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, fno);
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new FboardVO();
				vo.setfNo(rs.getInt("fno"));
				vo.setfWriter(rs.getString("fwriter"));
				vo.setfTitle(rs.getString("ftitle"));
				vo.setfDate(rs.getDate("fdate"));
				vo.setfContents(rs.getString("fcontents"));
				vo.setfHit(rs.getInt("fhit")); // 댓글수
				vo.setfcName(rs.getString("fcname"));
				vo.setfcSubject(rs.getString("fcsubject"));
				vo.setfcDate(rs.getDate("fcdate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}

	private void fCnoUpdate(int fNo) {
		// 조회수 증가
		String sql = "update fboard set fHit = fHit + 1 where fno = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, fNo);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int fboardInsert(FboardVO vo) {
		// 글 추가
		String sql = "insert into fboard (fno, fwriter, ftitle, fdate, fcontents) values(f_seq.nextval, ?, ?, sysdate, ?)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getfWriter());
			psmt.setString(2, vo.getfTitle());
			psmt.setString(3, vo.getfContents());
			n = psmt.executeUpdate();
			System.out.println(n +" : Fboardimpl");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int fboardDelete(FboardVO vo) {
		// 글삭제
		int n = 0;
		String sql = "delete from fboard where fno = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getfNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int fboardUpdate(FboardVO vo) {
		// 글 수정
		int n = 0;
		String sql = "update fboard set ftitle = ?, fcontents = ? where fNo = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getfTitle());
			psmt.setString(2, vo.getfContents());
			psmt.setInt(3, vo.getfNo());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int fcommentsInsert(FcommentsVO vo) {
		// 댓글 추가
		String sql = "insert into fcomments values(?, fc_seq.nextval, ?, ?, sysdate)";
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getfCno());
			psmt.setString(2, vo.getfcName());
			psmt.setString(3, vo.getfcSubject());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	@Override
	public int fcommentsDelete(FcommentsVO vo) {
		// 글삭제
		int n = 0;
		String sql = "delete from fcomments where fcno = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getfCno());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int fcommentsUpdate(FcommentsVO vo) {
		// 댓글 수정
		int n = 0;
		String sql = "update fcomments set fcsubject = ? where fcno= ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			System.out.println(vo.getfCno());
			System.out.println(vo.getfcSubject());
			psmt.setString(1, vo.getfcSubject());
			psmt.setInt(2, vo.getfCno());
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
	public List<FcommentsVO> fcommentsSelectList(int fNo) {
		// 댓글리스트
		List<FcommentsVO> list = new ArrayList<FcommentsVO>();
		int originalArticleNo = fNo;
		String sql = "select * from fcomments where fno = ?";
		FcommentsVO cvo;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, originalArticleNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				cvo = new FcommentsVO();
				cvo.setfNo(rs.getInt("fno"));
				cvo.setfCno(rs.getInt("fcno"));
				cvo.setfcName(rs.getString("fcname"));
				cvo.setfcSubject(rs.getString("fcsubject"));
				cvo.setfcDate(rs.getDate("fcdate"));
				list.add(cvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
}
