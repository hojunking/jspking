package co.yedam.sportscomu.sns.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.sns.service.SnsService;
import co.yedam.sportscomu.sns.serviceImpl.SnsServiceImpl;
import co.yedam.sportscomu.sns.vo.SnsVO;

public class CommentsForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 댓글 등록
		SnsService dao =new SnsServiceImpl();
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo =new SnsVO();
		vo.setcName(request.getParameter("cname"));
		vo.setcSubject(request.getParameter("csubject"));
		vo.setsNo(Integer.valueOf(request.getParameter("sNo")));
		int n=dao.commentsInsert(vo);
		String page = "";
		if(n !=0) {
			int m = Integer.valueOf(request.getParameter("sNo"));
			list = dao.snsSelect(m);
			request.setAttribute("list", list);
			page ="sns/snsDetail";
		}else {
			page ="board/boardError";
		}
		
		
		return page;
	}

}
