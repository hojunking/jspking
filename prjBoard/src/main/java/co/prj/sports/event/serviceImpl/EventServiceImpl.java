package co.prj.sports.event.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.prj.sports.board.dao.DataSource;
import co.prj.sports.event.service.EventService;
import co.prj.sports.event.vo.EventVO;

public class EventServiceImpl implements EventService {

	private DataSource datasource =DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public List<EventVO> eventSelectList() {
		List<EventVO> list= new ArrayList<EventVO>();
		EventVO vo;
		String sql="SELECT * FROM event";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while(rs.next()) {
				vo=new EventVO();
				vo.seteId(rs.getInt("eid"));
				vo.seteTitle(rs.getString("etitle"));
				vo.seteEvent(rs.getString("eevent"));
				vo.seteNumber(rs.getInt("enumber"));
				vo.seteCount(rs.getInt("ecount"));
				vo.seteDate(rs.getString("edate"));
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
	public int eventDelete(EventVO vo) {
		String sql="DELETE FROM event WHERE eid=?";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.geteId());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int eventInsert(EventVO vo) {
		String sql="INSERT INTO event(eid, etitle,eevent, enumber,edate)"
				+ "VALUES(b_SEQ.NEXTVAL,?,?,?,?)";
		int n=0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.geteId());
			psmt.setString(2, vo.geteTitle());
			psmt.setString(3, vo.geteEvent());
			psmt.setInt(4,vo.geteNumber());
			psmt.setString(5, vo.geteDate());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	@Override
	public void countUpdate(int eId) {
		String sql="UPDATE event SET ecount= ecount+1 WHERE eid=?";
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, eId);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
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
