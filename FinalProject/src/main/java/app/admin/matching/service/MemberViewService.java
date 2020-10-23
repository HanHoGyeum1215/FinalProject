package app.admin.matching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.mapper.MemberMapper;

@Service
@Component
public class MemberViewService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(String memId, Model model) throws Exception {
		MemberAddDTO dto=new MemberAddDTO();
		dto=memberMapper.selectAddInfo(memId).get(0);
		model.addAttribute("dto",dto);	
		}
}
