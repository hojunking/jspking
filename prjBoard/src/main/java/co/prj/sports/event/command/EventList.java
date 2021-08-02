package co.prj.sports.event.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.event.service.EventService;
import co.prj.sports.event.serviceImpl.EventServiceImpl;
import co.prj.sports.event.vo.EventVO;

public class EventList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		EventService dao= new EventServiceImpl();
		List<EventVO> list = new ArrayList<EventVO>();
		list=dao.eventSelectList();
		request.setAttribute("list", list);
		
		return "main/eventList";
	}

}
