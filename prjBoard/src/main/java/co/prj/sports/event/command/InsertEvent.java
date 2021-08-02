package co.prj.sports.event.command;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.event.service.EventService;
import co.prj.sports.event.serviceImpl.EventServiceImpl;
import co.prj.sports.event.vo.EventVO;

public class InsertEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		EventService dao = new EventServiceImpl();
		EventVO vo =new EventVO();
		
		vo.seteTitle(request.getParameter("eTitle"));
		vo.seteEvent(request.getParameter("eEvent"));
		vo.seteNumber(Integer.valueOf(request.getParameter("eNumber")));
		vo.seteDate(request.getParameter("eDate"));
		int n =dao.eventInsert(vo);
		String path="";
		if(n !=0) {
			path="eventList.do";
		}else {
			path="main/boardError";
		}
		return path;
	}
}
