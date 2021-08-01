package co.prj.sports.sns.service;

import java.util.List;

import co.prj.sports.comments.vo.CommentsVO;
import co.prj.sports.sns.vo.SnsVO;

public interface SnsService {
	List<SnsVO> snsSelectList();
	List<SnsVO> snsSelect(int no);
	int snsInsert(SnsVO vo);
	int commentsInsert(CommentsVO vo);
	int snsDelete(SnsVO vo);
	int commentsDelete(CommentsVO vo);
	int snsUpdate(SnsVO vo);
	int commentsUpdate(CommentsVO vo);
}
