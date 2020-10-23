package app.admin.course.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.course.command.MemberCommand2;
import app.admin.course.service.MemberDeleteService2;
import app.admin.course.service.MemberDetailService2;
import app.admin.course.service.MemberJoinService2;
import app.admin.course.service.MemberListService2;

@Controller
@RequestMapping("/admin/course/member")
public class CourseAdminMemberController {
	
	@ModelAttribute
	MemberCommand2 setMemberCommand() {
		return new MemberCommand2();
	}
	@Autowired
	MemberJoinService2 memberJoinService;
	@Autowired
	MemberListService2 memberListService;
	@Autowired
	MemberDetailService2 memberDetailService;
	@Autowired
	MemberDeleteService2 memberDeleteService;
	
	@RequestMapping("memberList")
	public String memberList(@RequestParam(value = "page" , defaultValue = "1")Integer page, Model model) throws Exception{
		memberListService.memberList(model,page);
		return "thymeleaf/admin/course/member/member_list";
	}
	
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "thymeleaf/admin/course/member/member_write";
	}
	
	@RequestMapping(value = "memberJoinOk", method = RequestMethod.POST)
	public String memberJoinOk(@Validated MemberCommand2 memberCommand, BindingResult result, Model model) throws Exception{
		if (result.hasErrors()) {
			return "thymeleaf/admin/course/member/member_write";
		}
		Integer i = memberJoinService.insertMember(memberCommand,model);
		if( i == null) return "thymeleaf/admin/course/member/member_write";
		return "redirect:/admin/course/member/memberList";
	}
	
	@RequestMapping(value = "memberView", method = RequestMethod.GET)
	public String memberView(@RequestParam(value="id") String memId, Model model)  throws Exception{
		memberDetailService.memberDetail(memId, model);
		return "thymeleaf/admin/course/member/member_view";
	}
	
	@RequestMapping(value = "memberDelete", method = RequestMethod.GET)
	public String memberDelete(@RequestParam(value="id") String memId) throws Exception{
		memberDeleteService.memberDelete(memId);
		return "redirect:/admin/course/member/memberList";
	}
	
	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/course/member/member_modify";
	}
}
