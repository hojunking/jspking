package co.yedam.sportscomu.sns.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.sns.service.SnsService;
import co.yedam.sportscomu.sns.serviceImpl.SnsServiceImpl;
import co.yedam.sportscomu.sns.vo.SnsVO;

public class SearchSns implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 1건 조회
		SnsService dao =new SnsServiceImpl();
		List<SnsVO> list = new ArrayList<SnsVO>();
		int n =Integer.valueOf(request.getParameter("sNo"));
		list= dao.snsSelect(n);
		request.setAttribute("list", list);
		
		return "sns/snsDetail";
	}

}
