package app.admin.course.controller.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app.admin.service.IdPwModifyService;
import app.admin.service.LoginService;
import app.command.ChangeIdCommand;
import app.command.ChangePwCommand;
import app.command.LoginCommand;
import app.controller.CookieAction;
import app.controller.LoginPrevUrl;

@Controller
@RequestMapping("/admin/course")
public class CourseAdminMainController {
	@Autowired
	CookieAction cookieAction;
	@Autowired
	LoginService loginService;
	@Autowired
	IdPwModifyService idPwModifyService;
	@Autowired
	LoginPrevUrl loginPrevUrl;
	
	@ModelAttribute
	LoginCommand setloginCommand() {
		return new LoginCommand();
	}
	@ModelAttribute
	ChangePwCommand setChangePwCommand() {
		return new ChangePwCommand();
	}
	@ModelAttribute
	ChangeIdCommand setChangeIdCommand() {
		return new ChangeIdCommand();
	}
	
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/admin/course/index";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginGet(
				HttpServletRequest request,
				Model model
			) {
		cookieAction.execute(request);
		loginPrevUrl.execute(request, model, "/admin/course/");
		return "thymeleaf/admin/common/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(
				@Validated LoginCommand loginCommand,
				BindingResult result,
				HttpServletRequest request,
				Model model,
				HttpServletResponse response
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/admin/common/login";
		}

		return loginService.execute(loginCommand, request, model, response);
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(
			HttpSession session,
			HttpServletResponse response
			) {
		Cookie autoLoginCookie = new Cookie("autoLogin", "");
		autoLoginCookie.setPath("/");
		autoLoginCookie.setMaxAge(0);
		response.addCookie(autoLoginCookie);
		session.invalidate();
		return "redirect:/admin/course/";
	}
	
	@RequestMapping(value = "findPassword", method = RequestMethod.GET)
	public String findPasswordGet() {
		return "thymeleaf/admin/common/forgot-password";
	}
	
	@RequestMapping(value = "findPassword", method = RequestMethod.POST)
	public String findPasswordPost(
				@Validated ChangePwCommand changePwCommand,
				BindingResult result,
				HttpServletRequest request,
				Model model
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/admin/common/forgot-password";
		}
		return idPwModifyService.changePw(changePwCommand, request, model, "emp");
	}
	
	@RequestMapping(value = "findId", method = RequestMethod.GET)
	public String findIdGet() {
		return "thymeleaf/admin/common/forgot-id";
	}
	
	@RequestMapping(value = "findId", method = RequestMethod.POST)
	public String findIdPost(
				@Validated ChangeIdCommand changeIdCommand,
				BindingResult result,
				HttpServletRequest request,
				Model model
			) throws Exception {
		if (result.hasErrors()) {
			return "thymeleaf/admin/common/forgot-id";
		}
		return idPwModifyService.findId(changeIdCommand, request, model, "emp");
	}
	
}
