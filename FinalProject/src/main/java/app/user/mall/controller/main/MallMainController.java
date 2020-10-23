package app.user.mall.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mall")
public class MallMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/mall/index";
	}
	
}
