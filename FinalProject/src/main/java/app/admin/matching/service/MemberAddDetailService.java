package app.admin.matching.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.mapper.MemberMapper;
import app.command.AuthInfo;

@Service
@Component
public class MemberAddDetailService {
	@Autowired
	MemberMapper memberMapper;
	public void execute(HttpSession session, Model model) throws Exception {
		String memId=((AuthInfo)session.getAttribute("authInfo")).getId();
		List<MemberAddDTO> list=memberMapper.selectAddInfo(memId);
		model.addAttribute("list",list);
	}
}
