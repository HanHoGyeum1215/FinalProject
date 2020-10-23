package app.admin.course.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import app.admin.course.command.PartnerCommand;
import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;

@Component
@Service
@Transactional
public class PartnerJoinService {

//	@Autowired
//	PasswordEncoder passwordEncoder;
	@Autowired
	PartnerMapper partnerMapper;
//	@Autowired
//	MailAction mailAction;
	public Integer insertPartner(PartnerCommand partnerCommand, Model model) {
		if(!partnerCommand.isVenPassEqualToReVenPass()) {
			model.addAttribute("valid_ReVenPass", "비밀번호가 일치하지 않습니다.");
			return null;
		}
		Integer result = null;
		PartnerDTO partnerDTO = new PartnerDTO();
		Timestamp venCdate = Timestamp.valueOf(partnerCommand.getVenCdate());
		partnerDTO.setVenId(partnerCommand.getVenId());
		partnerDTO.setVenPass(partnerCommand.getReVenPass());
//		memberDTO.setMemPass(passwordEncoder.encode(memberCommand.getMemPass()));
		partnerDTO.setVenName(partnerCommand.getVenName());
		partnerDTO.setVenTel(partnerCommand.getVenTel());
		partnerDTO.setVenNo(partnerCommand.getVenNo());
		partnerDTO.setVenAddr(partnerCommand.getVenAddr());
		partnerDTO.setVenCeo(partnerCommand.getVenCeo());
		partnerDTO.setVenCdate(venCdate);
		partnerDTO.setVenAcnt(partnerCommand.getVenAcnt());
		partnerDTO.setVenAcntNo(partnerCommand.getVenAcntNo());
		partnerDTO.setVenOk(partnerCommand.getVenOk());
		try {
			result = partnerMapper.insertPartner(partnerDTO);
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
