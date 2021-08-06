package co.song.prj.member.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.song.prj.common.DAO;
import co.song.prj.member.service.MemberService;
import co.song.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	
	
	private SqlSession sqlSession = DAO.getInstance().openSession();
	
	
	@Override
	public List<MemberVO> memberSelectList() {
		
		
		return sqlSession.selectList("memberSelectList");
		//mapper의 memberSelectList 명과 같아야 한다.
		//deo와 serviceImpl
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberSelect", vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberInsert", vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("memberUpdate", vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.delete("memberDelete", vo);
	}

}
