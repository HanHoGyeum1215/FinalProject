package app.admin.matching.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.MemberAddCommand;
import app.admin.matching.command.MemberCommand;
import app.admin.matching.service.MemberAddWriteService;
import app.admin.matching.service.MemberJoinService;
import app.admin.matching.service.MemberListService;
import app.admin.matching.service.MemberViewService;
import app.admin.matching.service.SurveySearchService;

@Controller
@RequestMapping("/admin/matching/member")
public class MatchingAdminMemberController {
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	MemberAddWriteService memberAddWriteService;
	@Autowired
	MemberListService memberListService;
	@Autowired
	SurveySearchService surveySearchService;
	@Autowired
	MemberViewService memberViewService;
	
	@RequestMapping("memberList")
	public String memberList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) throws Exception  {
				memberListService.memberList(model,page);
		return "thymeleaf/admin/matching/member/member_list";
	}

	@RequestMapping("memberView")
	public String memberView(@RequestParam(value = "memId")String memId, Model model) throws Exception {
		memberViewService.execute(memId, model);
		return "thymeleaf/admin/matching/member/member_view";
	}

	@RequestMapping("memberWrite")
	public String memberWrite(MemberCommand memberCommand) {
		return "thymeleaf/admin/matching/member/member_write";
	}

	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String memberJoin(@Valid MemberCommand memberCommand, BindingResult result, Model model) throws Exception {

		if (result.hasErrors()) {
			return "thymeleaf/admin/matching/member/member_write";
		}

		Integer i = memberJoinService.insertMember(memberCommand, model);
		if (i == null) {
			return "thymeleaf/admin/matching/member/member_write";
		}
		
		return "redirect:/";
	}

	@RequestMapping("memberAdd")
	public String memberAdd() {
		return "thymeleaf/admin/matching/member/member_add_write";
	}

	@RequestMapping(value = "memberAddWrite", method = RequestMethod.POST)
	public String memberAddWrite(MemberAddCommand memberAddCommand, HttpServletRequest request) throws Exception {
		Integer i = memberAddWriteService.insertMemberAdd(memberAddCommand, request);
		if (i == null) {
			return "thymeleaf/admin/matching/member/member_add_write";
		}
		return "redirect:/";

	}

	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/matching/member/member_modify";
	}

	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/matching/member/member_delete";
	}
	
	@RequestMapping("List")
	public String list(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model) throws Exception {
		memberListService.paidMemberList(model,page);
		return "thymeleaf/admin/matching/member/list";
	}
	
	@RequestMapping("surveyView")
	public String surveyView(@RequestParam(value = "memId")String memId, Model model) throws Exception {
		surveySearchService.execute(memId, model);
		return "thymeleaf/admin/matching/member/survey_view";
		
		
	}
}
