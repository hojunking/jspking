package co.prj.sports.event.service;

import java.util.List;

import co.prj.sports.event.vo.EventVO;

public interface EventService {
	List<EventVO> eventSelectList();
	int eventDelete(EventVO vo);
	int eventInsert(EventVO vo);
	void countUpdate(int eId);
}
