package co.prj.sports.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.sns.service.SnsService;
import co.prj.sports.sns.serviceImpl.SnsServiceImpl;
import co.prj.sports.sns.vo.SnsVO;

public class SnsInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		SnsService dao= new SnsServiceImpl();
		SnsVO vo=new SnsVO();
		vo.setsTitle(request.getParameter("sTitle"));
		vo.setsContents(request.getParameter("sContents"));
		vo.setsWriter(request.getParameter("sWriter"));
		int n= dao.snsInsert(vo);
		
		System.out.println(n);
		
		String path="";
		if(n != 0) {
			path="snsList.do";
		}else {
			path="main/boardError";
		}
		return path;
	}

}
