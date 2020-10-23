package app.admin.matching.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.command.MemberLoginCommand;
import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.command.AuthInfo;
import app.domain.StartEndPageDTO;

@Service
@Component
public class MemberLoginService {
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;
	AuthInfo authInfo = new AuthInfo();
	public String execute(MemberLoginCommand memberLoginCommand,HttpSession session, HttpServletResponse response, Model model) throws Exception{
		String location="";
		MemberDTO memberDTO=new MemberDTO();
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, memberLoginCommand.getUserId(), null);
		List<MemberDTO> list=memberMapper.selectMember(startEndPageDTO);
		System.out.println(memberDTO.getMemId());
		if (list.size()==0) {
			model.addAttribute("valid_mem", "존재하지 않는 계정입니다.");
			location="thymeleaf/common/login";
		}else {
			memberDTO=list.get(0);
			/* System.out.println(memberDTO.getMemPass()); */
			if (passwordEncoder.matches(memberLoginCommand.getUserPw(), memberDTO.getMemPass())) {
				System.out.println("로그인성공");
				authInfo.setId(memberDTO.getMemId());
				System.out.println(authInfo.getId());
				authInfo.setPw(memberDTO.getMemPass());
				System.out.println(authInfo.getPw());
				authInfo.setCondition("user");
				session.setAttribute("authInfo", authInfo);
				location="redirect:" + memberLoginCommand.getPath();
				
			}else {
				model.addAttribute("valid_pw","비밀번호가 틀립니다.");
				location="thymeleaf/common/login";
			}
		}
		
		return location;
	}
}
