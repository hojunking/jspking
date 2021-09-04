package co.song.data.serviceImpl;

import java.util.List;

import co.song.data.vo.TestVO;

public interface TestServiceMapper {
	public List<TestVO> testSelectList();
	public TestVO testSelect(TestVO vo);
	public int testUpdate(TestVO vo);
	public int testDelete(TestVO vo);
	public int testInsert(TestVO vo);
}
