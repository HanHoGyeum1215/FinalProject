package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.MemberDTO2;
import app.admin.course.mapper.MemberMapper2;

@Component
@Service
public class MemberDetailService2 {
	@Autowired
	MemberMapper2 memberMapper;

	public void memberDetail(String memId, Model model) throws Exception{
		MemberDTO2 member = new MemberDTO2();
		member.setMemId(memId);
		member = memberMapper.selectMember(member).get(0);
		model.addAttribute("memberCommand", member);
	}
	

}
