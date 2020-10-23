package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.command.MemberCommand;
import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.domain.StartEndPageDTO;

@Component
@Service
public class MemberModifyService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	public Integer updateMember(MemberCommand memberCommand) throws Exception {
		Integer result;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, memberCommand.getMemId(), null);
		MemberDTO mem = memberMapper.selectMember(startEndPageDTO).get(0);
		
		if (passwordEncoder.matches(memberCommand.getMemPass(), mem.getMemPass())) {
			System.out.println("패스워드 일치");
			MemberDTO dto = new MemberDTO();
			dto.setMemId(memberCommand.getMemId());
			dto.setMemEmail(memberCommand.getMemEmail());
			dto.setMemName(memberCommand.getMemName());
			dto.setMemTel(memberCommand.getMemTel());
			dto.setMemAddr(memberCommand.getMemAddr());
			result = memberMapper.updateMember(dto);
		} else {
			System.out.println("패스워드 불일치");
			result = 0;
		}
		
		return result;
		
	}
	
}
