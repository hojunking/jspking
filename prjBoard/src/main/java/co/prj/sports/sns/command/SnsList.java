package co.prj.sports.sns.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.prj.sports.board.command.Command;
import co.prj.sports.sns.service.SnsService;
import co.prj.sports.sns.serviceImpl.SnsServiceImpl;
import co.prj.sports.sns.vo.SnsVO;

public class SnsList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SnsService dao =new SnsServiceImpl();
		List<SnsVO> list= new ArrayList<SnsVO>();
		list =dao.snsSelectList();
		request.setAttribute("list", list);
		return "main/snsList";
	}

}
