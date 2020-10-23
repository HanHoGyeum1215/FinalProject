package app.user.matching.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.MemberAddCommand;
import app.admin.matching.service.MemberAddDetailService;
import app.admin.matching.service.MemberAddListService;
import app.admin.matching.service.MemberAddWriteService;

@Controller
@RequestMapping("mypage/matching")
public class MatchingMemberController {
	@Autowired
	MemberAddWriteService memberAddWriteService;
	@Autowired
	MemberAddListService memberAddListService;
	@Autowired
	MemberAddDetailService memberAddDetailService;	
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/matching/mypage/index";
	}
	@RequestMapping("memberAdd")
	public String memberAdd(HttpSession session, Model model) throws Exception {
		String location=memberAddListService.execute(session, model);
		return location;
	}
	
	 @RequestMapping("memberAddView") 
	 public String memberAddView(HttpSession session, Model model) throws Exception {
		 memberAddDetailService.execute(session,model);	
		 return "thymeleaf/matching/mypage/member_add_view";
	 }
	 
	
	@RequestMapping(value = "memberAddWrite")
	public String memberAddWrite(MemberAddCommand memberAddCommand, HttpServletRequest request) throws Exception {
		Integer i = memberAddWriteService.insertMemberAdd(memberAddCommand, request);
		if (i == null) {
			return "thymeleaf/matching/mypage/member_add_write";
		}
		return "redirect:/mypage/matching/memberAddView";

	}
	@RequestMapping("memberAddModify")
	public String memberAddModify() {
		return "thymeleaf/matching/mypage/member_add_write";
	}
	
}
