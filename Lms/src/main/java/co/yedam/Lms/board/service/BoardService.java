package co.yedam.Lms.board.service;

import java.util.List;

import co.yedam.Lms.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> boardSelectList();
	BoardVO boardSelect(BoardVO vo);
	int boardInsert(BoardVO vo);
	int boardDelete(BoardVO vo);
	int boardUpdate(BoardVO vo);
	
}
