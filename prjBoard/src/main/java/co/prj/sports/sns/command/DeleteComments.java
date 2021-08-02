package co.prj.sports.sns.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.sns.service.SnsService;
import co.prj.sports.sns.serviceImpl.SnsServiceImpl;
import co.prj.sports.sns.vo.SnsVO;

public class DeleteComments implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SnsService dao=new SnsServiceImpl();
		List<SnsVO> list = new ArrayList<SnsVO>();
		SnsVO vo = new SnsVO();
		vo.setcNo(Integer.valueOf(request.getParameter("cNo")));
		vo.setsNo(Integer.valueOf(request.getParameter("sNo")));
		System.out.println(vo+"스팟 1" );
		int n=dao.commentsDelete(vo);
		
		System.out.println(n+"스팟 2" );
		String path="";
		
		if(n !=0) {
			int m =Integer.valueOf(request.getParameter("sNo"));
			list= dao.snsSelect(m);
			request.setAttribute("list", list);
			path="main/snsDetail";
		}else {
			path="main/boardError";
		}
		return path;
	}
}
