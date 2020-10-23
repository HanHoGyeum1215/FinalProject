package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import app.admin.matching.command.MatchCommand;
import app.admin.matching.domain.MatchDTO;
import app.admin.matching.mapper.MatchMapper;

@Service
@Component
@Transactional
public class MatchModifyService {
	@Autowired
	MatchMapper matchMapper;
	public void execute(MatchCommand matchCommand, Model model) throws Exception{
		MatchDTO matchDTO=new MatchDTO();
		matchDTO.setMatCheck(matchCommand.getMatCheck());
		System.out.println(matchDTO.getMatCheck());
		matchDTO.setMatDate(matchCommand.getMatDate());
		System.out.println(matchDTO.getMatDate());
		matchDTO.setMatLoc(matchCommand.getMatLoc());
		System.out.println(matchDTO.getMatLoc());
		matchDTO.setMemId(matchCommand.getMemId());
		System.out.println(matchDTO.getMemId());
		matchDTO.setPartnerId(matchCommand.getPartnerId());
		System.out.println(matchDTO.getPartnerId());
		matchDTO.setMatNo(matchCommand.getMatNo());
		System.out.println(matchDTO.getMatNo());
		matchMapper.matchUpdate(matchDTO);
	}
}
