package app.admin.matching.service;

import java.sql.Timestamp;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import app.admin.matching.command.MemberCommand;
import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.controller.MailAction;
import app.controller.SmsSend;
import app.domain.MemberJoinOkDTO;
import app.domain.StartEndPageDTO;

@Service
@Component
@Transactional
public class MemberJoinService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	MailAction mailAction;
	public Integer insertMember(MemberCommand memberCommand,Model model) throws Exception {
		if (!memberCommand.isUserPwEqualToUserPwCon()) {
			model.addAttribute("valid_memPwCon","비밀번호가 일치하지 않습니다.");
			return null;
		}
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, memberCommand.getMemId(), null);
		List<MemberDTO> user = memberMapper.selectMember(startEndPageDTO);
		
		if (user.size() > 0) {
			model.addAttribute("duplicate_memId","사용중인 아이디 입니다.");
			return null;
		}
		
		Integer result = null;
		MemberDTO memberDTO = new MemberDTO();
		
		memberDTO.setMemPass(passwordEncoder.encode(memberCommand.getMemPass()));
		System.out.println(memberDTO.getMemPass());
		memberDTO.setMemAddr(memberCommand.getMemAddr());
		System.out.println(memberDTO.getMemAddr());
		memberDTO.setMemBirth(memberCommand.getMemBirth());
		System.out.println(memberDTO.getMemBirth());
		memberDTO.setMemEmail(memberCommand.getMemEmail());
		System.out.println(memberDTO.getMemEmail());
		memberDTO.setMemGender(memberCommand.getMemGender());
		System.out.println(memberDTO.getMemGender());
		memberDTO.setMemId(memberCommand.getMemId());
		System.out.println(memberDTO.getMemId());
		memberDTO.setMemName(memberCommand.getMemName());
		System.out.println(memberDTO.getMemName());
		memberDTO.setMemTel(memberCommand.getMemTel());
		System.out.println(memberDTO.getMemTel());
		
		try {
			result = memberMapper.insertMember(memberDTO);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if (result >= 1) {
			// SmsSend ss = new SmsSend();
			try {
				mailAction.sendMail(memberDTO.getMemEmail(),memberDTO.getMemId());
				// ss.smsSend(memberDTO.getMemTel(), memberDTO.getMemName()+"님 회원가입을 환영합니다.");
			} catch (MessagingException e) {
				// ss.smsSend(memberDTO.getMemTel(),memberDTO.getMemName()+"님 회원가입을 환영합니다2");
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
	public Integer updateJoinOk(String num, String userId) throws Exception {
		MemberJoinOkDTO dto = new MemberJoinOkDTO();
		dto.setNum(num);
		dto.setUserId(userId);
		
		return memberMapper.updateJoinOk(dto);
		
	}
}
