package app.admin.intra.service.ask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraAnswerDTO;
import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;

@Service
@Component
public class IntraAskDetailService {
	
	@Autowired
	IntraAskMapper IntraAskMapper;

	public void intraAskDetailService(Integer askNo, Model model)throws Exception{
		
		IntraAskDTO dto = IntraAskMapper.detailAsk(askNo);
		System.out.println(dto.getAnswerlist().size());
		model.addAttribute("intraAskCommand", dto);
	}
	
	/*
	public String intraAnswerListService(Integer askNo, Model model)throws Exception{
		String path = "";
		List<IntraAnswerDTO> answerList = IntraAskMapper.answerList(askNo);
		model.addAttribute("answerList",answerList);
		path = "thymeleaf/intra/ask/ask_detail";
		return path;
	}
	*/
	
}
