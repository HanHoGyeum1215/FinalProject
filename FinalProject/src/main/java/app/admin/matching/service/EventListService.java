package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.EventDTO;
import app.admin.matching.mapper.EventMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class EventListService {
	@Autowired
	EventMapper eventMapper;
	public void execute(Model model, Integer page) throws Exception {
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * limit +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow,endRow);
		List<EventDTO> list=eventMapper.selectEvent(startEndPageDTO);
		int count = eventMapper.getEventCount();
		model.addAttribute("eventList",list);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "eventList");
	}
}
