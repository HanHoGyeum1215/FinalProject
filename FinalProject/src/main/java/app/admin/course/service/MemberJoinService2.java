package app.admin.course.service;

import java.sql.Timestamp;


//import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import app.admin.course.command.MemberCommand2;
import app.admin.course.domain.MemberDTO2;
import app.admin.course.mapper.MemberMapper2;

@Component
@Service
@Transactional
public class MemberJoinService2 {

//	@Autowired
//	PasswordEncoder passwordEncoder;
	@Autowired
	MemberMapper2 memberMapper;
//	@Autowired
//	MailAction mailAction;
	
	public Integer insertMember(MemberCommand2 memberCommand, Model model) throws Exception{

		if(!memberCommand.isMemPassEqualToReMemPass()) {
			model.addAttribute("valid_ReMemPass", "비밀번호가 일치하지 않습니다.");
			return null;
		}
		Integer result = null;
		MemberDTO2 memberDTO = new MemberDTO2();
		Timestamp memBirth = Timestamp.valueOf(memberCommand.getMemBirth());
		memberDTO.setMemId(memberCommand.getMemId());
		memberDTO.setMemPass(memberCommand.getMemPass());
//		memberDTO.setMemPass(passwordEncoder.encode(memberCommand.getMemPass()));
		memberDTO.setMemName(memberCommand.getMemName());
		memberDTO.setMemBirth(memBirth);
		memberDTO.setMemAddr(memberCommand.getMemAddr());
		memberDTO.setMemEmail(memberCommand.getMemEmail());
		memberDTO.setMemTel(memberCommand.getMemTel());
		try {
			result = memberMapper.insertMember(memberDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
//		if(result != null) {
//			SmsSend ss = new SmsSend();
//			try {
//				mailAction.sendMail(memberDTO.getUserEmail(), 
//						memberDTO.getUserId());
//				ss.smsSend(memberDTO.getUserPh1(), 
//						memberDTO.getUserName()+"님 회원가입을 축하합니다.");
//			} catch (MessagingException e) {
//				ss.smsSend(memberDTO.getUserPh1(), 
//			memberDTO.getUserName()+"님 회원가입을 축하합니다. "
//								+ "그러나 1254-1254로 문의 바랍니다.");
//				e.printStackTrace();
//			}
//		}else {
//			model.addAttribute("duplicate_userId","사용중인 아이디입니다.");
//		}
		return result;
	
	}

}
