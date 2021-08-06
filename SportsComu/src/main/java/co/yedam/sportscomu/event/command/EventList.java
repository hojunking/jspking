package co.yedam.sportscomu.event.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.serviceImpl.EventServiceImpl;
import co.yedam.sportscomu.event.vo.EventVO;

public class EventList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		EventService dao= new EventServiceImpl();
		List<EventVO> list = new ArrayList<EventVO>();
		HttpSession session = request.getSession();
		list = dao.eventSelectList();
		session.setAttribute("list", list);
		
		return "event/eventList";
	}

}
