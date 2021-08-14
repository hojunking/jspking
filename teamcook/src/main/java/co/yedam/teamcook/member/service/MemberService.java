package co.yedam.teamcook.member.service;

import java.util.List;

import co.yedam.teamcook.member.vo.MemberVO;

public interface MemberService {
	List<MemberVO> memberSelectList();
	MemberVO memberLogin(MemberVO vo);
	MemberVO memberSelect(MemberVO vo);
	int memberInsert(MemberVO vo);
	int memberDelete(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberIdCheck(MemberVO vo);
}
