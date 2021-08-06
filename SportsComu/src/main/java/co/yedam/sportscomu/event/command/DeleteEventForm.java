package co.yedam.sportscomu.event.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.serviceImpl.EventServiceImpl;
import co.yedam.sportscomu.event.vo.EventVO;

public class DeleteEventForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EventService dao= new EventServiceImpl();
		List<EventVO> list = new ArrayList<EventVO>();
		list=dao.eventSelectList();
		request.setAttribute("list", list);
		
		return "event/deleteEventForm";
	}

}
