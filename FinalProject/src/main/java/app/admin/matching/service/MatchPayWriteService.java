package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.matching.command.MatchPayCommand;
import app.admin.matching.domain.MatchPayDTO;
import app.admin.matching.mapper.MatchMapper;

@Service
@Component
public class MatchPayWriteService {
	@Autowired
	MatchMapper matchMapper;
	public void execute(MatchPayCommand matchPayCommand) throws Exception {
		MatchPayDTO matchPayDTO = new MatchPayDTO();
		matchPayDTO.setMatPayPrice(matchPayCommand.getMatPayPrice());
		matchPayDTO.setMatPayReq(matchPayCommand.getMatPayReq());
		matchPayDTO.setMatPayWay(matchPayCommand.getMatPayWay());
		matchPayDTO.setMemId(matchPayCommand.getMemId());
		matchMapper.matchPayInsert(matchPayDTO);
	
	}
}
