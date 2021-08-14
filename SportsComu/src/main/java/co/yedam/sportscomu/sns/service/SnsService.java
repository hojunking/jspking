package co.yedam.sportscomu.sns.service;

import java.util.List;

import co.yedam.sportscomu.comments.vo.CommentsVO;
import co.yedam.sportscomu.sns.vo.SnsVO;

public interface SnsService {
	List<SnsVO> snsSelectList();
	List<SnsVO> snsSelect(int sNo);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsDelete(SnsVO vo);
	void commentsDeleteAll(int sNo);
	int snsUpdate(SnsVO vo);
	int commentsDelete(CommentsVO vo);
	void sHitUpdate(int sNo);
	void sAnoUpdate(int sNo);
	void sAnoUpdatedown(int sNo);
}
