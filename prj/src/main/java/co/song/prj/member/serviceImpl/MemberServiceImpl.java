/**
 * 
 */
package co.song.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.song.prj.dao.DataSource;
import co.song.prj.member.service.MemberService;
import co.song.prj.member.vo.MemberVO;

/**
 * @author admin
 *
 */
public class MemberServiceImpl implements MemberService {
	
	private DataSource datasource =DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list =new ArrayList<MemberVO>();
		MemberVO vo;
		String sql= "SELECT* FROM member";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs =psmt.executeQuery();
			while(rs.next()) {
				vo=new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setName(rs.getString("name"));
				vo.setAge(rs.getInt("age"));
				vo.setHobby(rs.getString("hobby"));
				vo.setState(rs.getString("state").charAt(0));
				list.add(vo);
				System.out.println(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql ="SELECT name,author FROM member WHERE id=? AND password=? AND state='Y'";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs=psmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setAuthor(rs.getString("author"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	private void close() {
		try {
			if(rs !=null) {rs.close();}
			if(psmt !=null) {psmt.close();}
			if(conn !=null) {conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
