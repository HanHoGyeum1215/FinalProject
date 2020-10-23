package app.admin.intra.service.commute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraCommuteDTO;
import app.admin.intra.mapper.IntraCommuteMapper;

@Service
@Component
public class IntraCommuteListServie {
	
	@Autowired
	IntraCommuteMapper intraCommuteMapper;

	public void listService(Model model)throws Exception{
		 
		List<IntraCommuteDTO> lists = intraCommuteMapper.commuteList();
		
		int count = intraCommuteMapper.commuteCount();

		model.addAttribute("commuteList", lists);
		model.addAttribute("count", count);
	
	}
}
