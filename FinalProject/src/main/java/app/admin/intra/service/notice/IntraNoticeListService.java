package app.admin.intra.service.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class IntraNoticeListService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;

	public void listService(int page,Model model)throws Exception{
		
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long) page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow);
	    
		List<IntraNoticeDTO> lists = intraNoticeMapper.viewNotice(dto);
		int count = intraNoticeMapper.noticeCount();
		
	   model.addAttribute("noticeList", lists);
	   model.addAttribute("count", count);
		
	   PageAction pageAction = new PageAction();
	   pageAction.page(model, count, limit, limitPage, page, "noticeList");
	}
}
