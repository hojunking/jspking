package co.song.prj.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.song.prj.board.service.BoardMapper;
import co.song.prj.board.service.BoardService;
import co.song.prj.board.vo.CommentsVO;
import co.song.prj.board.vo.SnsVO;
import co.song.prj.common.DataSource;

public class BoardServiceImpl implements BoardService {
	private SqlSession sqlSession=DataSource.getInstance().openSession();
	private BoardMapper map=sqlSession.getMapper(BoardMapper.class); // Mapper Interface 사용
	@Override
	public List<SnsVO> snsSelectList() {
		// TODO Auto-generated method stub
		return map.snsSelectList();
	}

	@Override
	public List<SnsVO> snsSelect(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsSelect(vo);
	}

	@Override
	public CommentsVO commentsSelect(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsSelect(vo);
	}

	@Override
	public int snsInsert(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsInsert(vo);
	}

	@Override
	public int commentsInsert(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsInsert(vo);
	}

	@Override
	public int snsUpdate(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsUpdate(vo);
	}

	@Override
	public int commentsUpdate(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsUpdate(vo);
	}

	@Override
	public int snsDelete(SnsVO vo) {
		// TODO Auto-generated method stub
		return map.snsDelete(vo);
	}

	@Override
	public int commentsDelete(CommentsVO vo) {
		// TODO Auto-generated method stub
		return map.commentsDelete(vo);
	}

}
