package app.controller.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.MemberCommand;
import app.admin.matching.command.MemberLoginCommand;
import app.admin.matching.service.MemberJoinService;
import app.admin.matching.service.MemberLoginService;
import app.admin.service.IdPwModifyService;
import app.command.ChangeIdCommand;
import app.command.ChangePwCommand;
import app.controller.LoginPrevUrl;

@Controller
@RequestMapping("/")
public class MemberController {
	@Autowired
	MemberLoginService memberLoginService; 
	@Autowired
	MemberJoinService memberJoinService;
	@Autowired
	IdPwModifyService idPwModifyService;
	@Autowired
	LoginPrevUrl loginPrevUrl;
	
	@ModelAttribute
	MemberCommand setMemberCommand() {
		return new MemberCommand();
	}
	@ModelAttribute
	MemberLoginCommand setMemberLoginCommand() {
		return new MemberLoginCommand();
	}
	@ModelAttribute
	ChangeIdCommand setChangeIdCommand() {
		return new ChangeIdCommand();
	}
	@ModelAttribute
	ChangePwCommand setChangePwCommand() {
		return new ChangePwCommand();
	}
	
	@RequestMapping("login")
	public String login(
				HttpServletRequest request,
				Model model
			) {
		loginPrevUrl.execute(request, model, "/");
		return "thymeleaf/common/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login1(
			@Validated MemberLoginCommand memberLoginCommand,
			BindingResult result, HttpSession session,
			HttpServletResponse response, Model model) throws Exception {
		if (result.hasErrors()) {
			 return "thymeleaf/common/login";
		}
		String location = memberLoginService.execute(memberLoginCommand,session,response,model);
		return location;
	}
	
	@RequestMapping(value = "logout2", method = RequestMethod.GET)
	public String logout(
				HttpSession session,
				HttpServletResponse response
			) {
		Cookie autoLoginCookie = new Cookie("autoLogin", "");
		autoLoginCookie.setPath("/");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberJoin2", method = RequestMethod.POST)
	public String memberJoin2(
				@Valid MemberCommand memberCommand, 
				BindingResult result, 
				Model model
			) throws Exception {

		if (result.hasErrors()) {
			return "thymeleaf/common/login";
		}

		Integer i = memberJoinService.insertMember(memberCommand, model);
		if (i == null) {
			return "thymeleaf/common/login";
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "findIdPw", method = RequestMethod.GET)
	public String findPasswordGet() {
		return "thymeleaf/common/forgot-id-pw";
	}
	
	@RequestMapping(value = "findPassword", method = RequestMethod.POST)
	public String findPasswordPost(
				@Validated ChangePwCommand changePwCommand,
				BindingResult result,
				HttpServletRequest request,
				Model model
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/common/forgot-id-pw";
		}
		return idPwModifyService.changePw(changePwCommand, request, model, "mem");
	}
	
	@RequestMapping(value = "findId", method = RequestMethod.POST)
	public String findIdPost(
				@Validated ChangeIdCommand changeIdCommand,
				BindingResult result,
				HttpServletRequest request,
				Model model
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/common/forgot-id-pw";
		}
		return idPwModifyService.findId(changeIdCommand, request, model, "mem");
	}
	
	@RequestMapping(value = "register/memberMail", method = RequestMethod.GET)
	public String memberMail(
				@RequestParam("num") String num,
				@RequestParam("userId") String userId
			) throws Exception {
		int i = memberJoinService.updateJoinOk(num, userId);
		if (i >= 1) {
			return "thymeleaf/common/success";
		}
		return "thymeleaf/common/fail";
	}
	
	
	
}