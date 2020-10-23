package app.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.matching.command.MemberCommand;
import app.admin.matching.service.MemberDetailService;
import app.admin.matching.service.MemberModifyService;

@Controller
@RequestMapping("mypage")
public class MemberMyInfoController {
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MemberModifyService memberModifyService;
	
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping("myinfo/{id}")
	public String myinfo(
			@PathVariable(value = "id") String memId,
			Model model
		) throws Exception {
		memberDetailService.memberDetail(model, memId);
		return "thymeleaf/common/myinfo";
	}
	@RequestMapping("mymodify/{id}")
	public String mymodify(
			@PathVariable(value = "id") String memId,
			Model model
		) throws Exception {
		memberDetailService.memberDetail(model, memId);
		return "thymeleaf/common/member_modify";
	}
	@RequestMapping(value = "mymodifyPro", method = RequestMethod.POST)
	public String mymodifyPro(
			@Validated MemberCommand memberCommand,
			BindingResult result,
			Model model
		) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/common/member_modify";
		}
		
		Integer i = memberModifyService.updateMember(memberCommand);
		if (i >= 1) {
			return "redirect:/mypage/myinfo/" + memberCommand.getMemId();
		}
		
		model.addAttribute("valid_memPwCon", "비밀번호가 일치하지 않습니다.");
		return "thymeleaf/common/member_modify";
	}
	
}
