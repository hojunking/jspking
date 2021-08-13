package co.yedam.sportscomu.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.serviceImpl.EventServiceImpl;
import co.yedam.sportscomu.event.vo.EventVO;

public class InsertEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
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
			path="board/boardError";
		}
		return path;
	}

}
