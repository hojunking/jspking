package co.prj.sports.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.prj.sports.board.command.Command;
import co.prj.sports.event.service.EventService;
import co.prj.sports.event.serviceImpl.EventServiceImpl;
import co.prj.sports.event.vo.EventVO;

public class CountEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//신청자 카운트 업
		EventService dao = new EventServiceImpl();
		EventVO vo= new EventVO();
		
		vo.seteId(Integer.valueOf(request.getParameter("eId")));
		int n=dao.countUpdate(vo);
		System.out.println(n + "과연");
		String path="";
		if(n !=0) {
			path="eventList.do";
		}else {
			String msg="해당 이벤트는 마감되었습니다";
			request.setAttribute("message", msg);
			path="eventList.do";
		}
		return path;
	}

}
