package app.user.matching.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("matching")
public class MatchingMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/matching/index";
	}
	
}
