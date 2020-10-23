package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MatchDTO;
import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MatchMapper;
import app.admin.matching.mapper.MemberMapper;
import app.domain.StartEndPageDTO;

@Service
@Component
public class MatchDetailService {
	@Autowired
	MatchMapper matchMapper;
	@Autowired
	MemberMapper memberMapper;
	public void execute(String matNo, String partnerId, Model model) throws Exception {
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L,1L,partnerId,matNo);
		MatchDTO matchDTO=matchMapper.selectMatch(startEndPageDTO).get(0);
		model.addAttribute("matchDTO",matchDTO);
		MemberDTO memberDTO=memberMapper.selectMember(startEndPageDTO).get(0);
		model.addAttribute("partner",memberDTO);
	}
}
