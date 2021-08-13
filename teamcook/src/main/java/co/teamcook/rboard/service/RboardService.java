package co.teamcook.rboard.service;

import java.util.List;

import co.teamcook.rboard.vo.RboardVO;
import co.teamcook.rboard.vo.RcommentVO;

public interface RboardService {
	List<RboardVO> rboardSelectList();

	RboardVO rboardSelect(int rno);

	//메인 글의 업데이트 문
	int rboardInsert(RboardVO vo);

	int rboardDelete(RboardVO vo);

	int rboardUpdate(RboardVO vo);

	//댓글의 업데이트 문
	int rcommentInsert(RcommentVO vo);

	int rcommentDelete(RcommentVO vo);

	int rcommentUpdate(RcommentVO vo);

	List<RcommentVO> rcommentsSelectList(int rNo);
}
