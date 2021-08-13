package co.yedam.sportscomu.event.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.sportscomu.dao.DataSource;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.vo.EventVO;

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
			psmt.setString(1, vo.geteTitle());
			psmt.setString(2, vo.geteEvent());
			psmt.setInt(3,vo.geteNumber());
			psmt.setString(4, vo.geteDate());
			n=psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}

	@Override
	public int countUpdate(EventVO vo) {
		String sql="UPDATE event SET ecount=ecount+1 WHERE eid=?";
		int n = 0;
		try {
			conn=datasource.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, vo.geteId());
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	@Override
	public EventVO eventSelectOne(EventVO vo) {
		String sql = "select ecount,enumber from event where eid=?";
		try {
			conn = datasource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.geteId());
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				vo.seteCount(rs.getInt("ecount"));
				vo.seteNumber(rs.getInt("enumber"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
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
