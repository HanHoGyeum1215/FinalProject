package app.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/index";
	}
	@RequestMapping("/sub")
	public String sub() {
		return "thymeleaf/sub";
	}
	
	@RequestMapping("/test/")
	public String t() {
		return "thymeleaf/test/index";
	}
	@RequestMapping("/test/buttons")
	public String t1() {
		return "thymeleaf/test/buttons";
	}
	@RequestMapping("/test/cards")
	public String t2() {
		return "thymeleaf/test/cards";
	}
	@RequestMapping("/test/colors")
	public String t3() {
		return "thymeleaf/test/utilities-color";
	}
	@RequestMapping("/test/borders")
	public String t4() {
		return "thymeleaf/test/utilities-border";
	}
	@RequestMapping("/test/animations")
	public String t5() {
		return "thymeleaf/test/utilities-animation";
	}
	@RequestMapping("/test/other")
	public String t6() {
		return "thymeleaf/test/utilities-other";
	}
	@RequestMapping("/test/login")
	public String t7() {
		return "thymeleaf/test/login";
	}
	@RequestMapping("/test/register")
	public String t8() {
		return "thymeleaf/test/register";
	}
	@RequestMapping("/test/forgotPass")
	public String t9() {
		return "thymeleaf/test/forgot-password";
	}
	@RequestMapping("/test/blank")
	public String t10() {
		return "thymeleaf/test/blank";
	}
	@RequestMapping("/test/charts")
	public String t11() {
		return "thymeleaf/test/charts";
	}
	@RequestMapping("/test/tables")
	public String t12() {
		return "thymeleaf/test/tables";
	}
	@RequestMapping("/test/forms")
	public String t13() {
		return "thymeleaf/test/forms";
	}
	
}
