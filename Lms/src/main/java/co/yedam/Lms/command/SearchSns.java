package co.yedam.Lms.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.Lms.sns.service.SnsService;
import co.yedam.Lms.sns.serviceImpl.SnsServiceImpl;
import co.yedam.sns.vo.SnsVO;

public class SearchSns implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 선택된 SNS글을 가져온다.
		SnsService snsDao=new SnsServiceImpl();
		List<SnsVO> list= new ArrayList<SnsVO>();
		int n=Integer.valueOf(request.getParameter("sNo"));
		list = snsDao.snsSelect(n);
		request.setAttribute("list", list);
		return "main/snsDetail";
	}

}
