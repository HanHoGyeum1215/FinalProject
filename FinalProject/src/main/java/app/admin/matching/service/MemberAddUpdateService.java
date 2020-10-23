package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.matching.command.MatchPayCommand;
import app.admin.matching.mapper.MemberMapper;

@Service
@Component
public class MemberAddUpdateService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(MatchPayCommand matchPayCommand) throws Exception {
		memberMapper.updateMemberAdd(matchPayCommand.getMemId());
	}
}
