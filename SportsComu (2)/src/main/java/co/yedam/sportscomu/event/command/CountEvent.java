package co.yedam.sportscomu.event.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.sportscomu.common.Command;
import co.yedam.sportscomu.event.service.EventService;
import co.yedam.sportscomu.event.serviceImpl.EventServiceImpl;
import co.yedam.sportscomu.event.vo.EventVO;

public class CountEvent implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//신청자 카운트 업
		EventService dao = new EventServiceImpl();
		EventVO vo= new EventVO();
		
		vo.seteId(Integer.valueOf(request.getParameter("eId")));
		vo = dao.eventSelectOne(vo);
		
		int num = vo.geteNumber();
		int cun = vo.geteCount();
		String page = "";
		if (num > cun) {
			vo.seteId(Integer.valueOf(request.getParameter("eId")));
			int n = dao.countUpdate(vo);
			if (n != 0) {
				page = "eventList.do";
			} else {
				page = "board/boardError";
			}
		} else {
			String msg="해당 이벤트는 마감되었습니다";
			request.setAttribute("message", msg);
			page = "eventList.do";
		}
		return page;
	}
}
