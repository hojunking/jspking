package co.yedam.sportscomu.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.serviceImpl.EventServiceImpl;
import co.yedam.sportscomu.event.vo.EventVO;

public class DeleteEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EventService dao = new EventServiceImpl();
		EventVO vo =new EventVO();
		vo.seteId(Integer.valueOf(request.getParameter("eId")));
		int n= dao.eventDelete(vo);
		String path="";
		if(n !=0) {
			path="deleteEventForm.do";
		}else {
			path="board/boardError";
		}
		return path;
	}

}
