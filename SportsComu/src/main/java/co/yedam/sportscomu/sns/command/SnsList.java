package co.yedam.sportscomu.sns.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.sns.service.SnsService;
import co.yedam.sportscomu.sns.serviceImpl.SnsServiceImpl;
import co.yedam.sportscomu.sns.vo.SnsVO;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SnsService dao =new SnsServiceImpl();
		List<SnsVO> list= new ArrayList<SnsVO>();
		list = dao.snsSelectList();
		request.setAttribute("list", list);
		
		return "sns/snsList";
	}

}
