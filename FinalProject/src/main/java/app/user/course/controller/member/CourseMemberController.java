package app.user.course.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage/course")
public class CourseMemberController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/course/mypage/index";
	}
	@RequestMapping("orderList")
	public String orderList() {
		return "thymeleaf/course/mypage/order_list";
	}
}
