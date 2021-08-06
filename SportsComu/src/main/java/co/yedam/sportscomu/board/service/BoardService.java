package co.yedam.sportscomu.board.service;

import java.util.List;

import co.yedam.sportscomu.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardUpdate(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardInsert(BoardVO vo);
	void hitUpdate(int id);
}
