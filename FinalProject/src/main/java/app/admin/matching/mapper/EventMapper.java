package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.EventDTO;
import app.admin.matching.domain.EventJoinDTO;
import app.domain.StartEndPageDTO;

@Component
@Repository
public interface EventMapper {
	public void eventInsert(EventDTO dto);
	public List<EventDTO> selectEvent(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getEventCount();
	public void eventJoin(EventJoinDTO dto) throws Exception;
	public void eventJoinApp(String eveNo) throws Exception;
	public Integer eventUpdate(EventDTO eventDTO) throws Exception;
	public Integer eventDel(EventDTO eventDTO) throws Exception;
}
