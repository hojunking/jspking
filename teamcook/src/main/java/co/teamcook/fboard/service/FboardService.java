package co.teamcook.fboard.service;

import java.util.List;

import co.teamcook.fboard.vo.FboardVO;
import co.teamcook.fboard.vo.FcommentsVO;

public interface FboardService {
	List<FboardVO> fboardSelectList();

	FboardVO fboardSelect(int fno);

	// 메인 글의 업데이트 문
	int fboardInsert(FboardVO vo);

	int fboardDelete(FboardVO vo);

	int fboardUpdate(FboardVO vo);

	List<FcommentsVO> fcommentsSelectList(int fNo);
	
	// 댓글의 업데이트 문
	int fcommentsInsert(FcommentsVO vo);

	int fcommentsDelete(FcommentsVO vo);

	int fcommentsUpdate(FcommentsVO vo);
}
