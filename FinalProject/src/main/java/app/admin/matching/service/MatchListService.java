package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MatchDTO;
import app.admin.matching.mapper.MatchMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class MatchListService {
	@Autowired
	MatchMapper matchMapper;
	public void execute(Model model, Integer page) throws Exception {
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		StartEndPageDTO startEndPageDTO = 
				new StartEndPageDTO(startRow,endRow);
		List<MatchDTO> list=matchMapper.selectMatch(startEndPageDTO);
		int count=matchMapper.getMatchCount();
		model.addAttribute("matchList",list);
		model.addAttribute("count",count);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "matchList?");
		
	}
}
