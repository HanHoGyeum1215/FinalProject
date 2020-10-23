package app.admin.mall.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mall")
public class MallAdminMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/admin/mall/index";
	}
	
}
