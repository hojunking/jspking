package co.song.prj.board.service;

import java.util.List;


import co.song.prj.board.vo.CommentsVO;
import co.song.prj.board.vo.SnsVO;

public interface BoardMapper {
	List<SnsVO> snsSelectList();
	List<SnsVO> snsSelect(SnsVO vo);
	CommentsVO commentsSelect(CommentsVO vo);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelete(CommentsVO vo);
}
