package co.yedam.sportscomu.member.service;

import java.util.List;

import co.yedam.sportscomu.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectAll();
	MemberVO memberSelectOne(MemberVO vo);
	MemberVO memberLogin(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	int checkId(String id);
}
