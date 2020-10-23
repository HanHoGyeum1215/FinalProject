package app.partner.mall.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/mall")
public class MallPartnerMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/partner/mall/index";
	}
	
}
