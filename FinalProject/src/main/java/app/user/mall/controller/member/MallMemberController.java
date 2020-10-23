package app.user.mall.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mypage/mall")
public class MallMemberController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/mall/mypage/index";
	}
	@RequestMapping("orderList")
	public String orderList() {
		return "thymeleaf/mall/mypage/order_list";
	}
	@RequestMapping("deliveryList")
	public String deliveryList() {
		return "thymeleaf/mall/mypage/delivery_list";
	}
	
}
