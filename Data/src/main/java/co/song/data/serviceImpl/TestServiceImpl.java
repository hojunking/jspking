package co.song.data.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.song.data.common.DataSource;
import co.song.data.vo.TestVO;

public class TestServiceImpl {
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private TestServiceMapper map = sqlSession.getMapper(TestServiceMapper.class);
	

	public List<TestVO> testSelectList(){
		return map.testSelectList();
	}
	public TestVO testSelect(TestVO vo){
		return map.testSelect(vo);
	}
	public int testUpdate(TestVO vo) {
		return map.testUpdate(vo);
	}
	public int testDelete(TestVO vo) {
		return map.testDelete(vo);
	}
	public int testInsert(TestVO vo) {
		return map.testInsert(vo);
	}
	
	}

