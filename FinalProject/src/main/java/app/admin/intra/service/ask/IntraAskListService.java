package app.admin.intra.service.ask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class IntraAskListService {
	
	@Autowired
	IntraAskMapper intraAskMapper;

	public void listServie(int page, Model model)throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long) page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow);
		List<IntraAskDTO> lists = intraAskMapper.listAsk(dto);
		int count = intraAskMapper.countAsk();
		
		
		model.addAttribute("askList", lists);
		model.addAttribute("count",count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "askList");
	}
	
}
