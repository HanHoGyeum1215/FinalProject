package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.domain.SurveyDTO;
import app.admin.matching.mapper.MemberMapper;
import app.admin.matching.mapper.SurveyMapper;
import app.domain.StartEndPageDTO;

@Service
@Component
public class SurveySearchService {
	@Autowired
	SurveyMapper surveyMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memId, Model model) throws Exception {
		SurveyDTO surveyDTO=new SurveyDTO();
		MemberDTO memberDTO=new MemberDTO();
		
		StartEndPageDTO startEndPageDTO=new StartEndPageDTO(1L,1L,memId,null);
		memberDTO=memberMapper.selectMember(startEndPageDTO).get(0);
		
		surveyDTO=surveyMapper.selectSurvey(memId);
		surveyDTO.setMemGender(memberDTO.getMemGender());
		List<MemberDTO> list=surveyMapper.selectMember(surveyDTO);
		model.addAttribute("memberList",list);
		model.addAttribute("memId",memId);
		model.addAttribute("survey",surveyDTO);
		
	}

}
