package co.yedam.teamcook.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.teamcook.dao.DataSource;
import co.yedam.teamcook.member.service.MemberService;
import co.yedam.teamcook.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
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
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";

		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				vo.setState(rs.getString("state"));
				list.add(vo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "select * from member where id=? and password =? and state='Y'";

		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				vo.setState(rs.getString("state"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "select * from member where id=?";

		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();

			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setAuthor(rs.getString("author"));
				vo.setState(rs.getString("state"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "insert into member(id, password, name, email) values (?,?,?,?)";

		dataSource = DataSource.getInstance();
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			psmt.setString(3, vo.getName());
			psmt.setString(4, vo.getEmail());
			n= psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "update member set state=? where id=?";

		dataSource = DataSource.getInstance();
		int n = 0;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "D");
			psmt.setString(2, vo.getId());
			
			n= psmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int memberIdCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		String sql = "select name from member where id=?";
		int x = 0;
		dataSource = DataSource.getInstance();

		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			
			rs = psmt.executeQuery();
			
			
			if (rs.next()) {
				x=1;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
		
	}
	
}
