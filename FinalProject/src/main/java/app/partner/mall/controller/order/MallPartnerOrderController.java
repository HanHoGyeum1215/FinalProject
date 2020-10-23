package app.partner.mall.controller.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/mall/order")
public class MallPartnerOrderController {
	@RequestMapping("orderList")
	public String orderList() {
		return "thymeleaf/partner/mall/order/order_list";
	}
	@RequestMapping("orderView")
	public String orderView() {
		return "thymeleaf/partner/mall/order/order_view";
	}
}
