package co.prj.sports.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.event.service.EventService;
import co.prj.sports.event.serviceImpl.EventServiceImpl;
import co.prj.sports.event.vo.EventVO;

public class DeleteEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		EventService dao = new EventServiceImpl();
		EventVO vo =new EventVO();
		vo.seteId(Integer.valueOf(request.getParameter("eId")));
		int n= dao.eventDelete(vo);
		System.out.println(n+"스팟요");
		String path="";
		if(n !=0) {
			path="deleteEventForm.do";
		}else {
			path="main/boardError";
		}
		return path;
	}

}
