package co.yedam.sportscomu.event.service;

import java.util.List;

import co.yedam.sportscomu.event.vo.EventVO;

public interface EventService {
	List<EventVO> eventSelectList();
	EventVO eventSelectOne(EventVO vo);
	int eventDelete(EventVO vo);
	int eventInsert(EventVO vo);
	int countUpdate(EventVO vo);
}
