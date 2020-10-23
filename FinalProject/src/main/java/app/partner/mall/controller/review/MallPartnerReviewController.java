package app.partner.mall.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/mall/review")
public class MallPartnerReviewController {
	@RequestMapping("reviewList")
	public String reviewList() {
		return "thymeleaf/partner/mall/review/review_list";
	}
	@RequestMapping("reviewView")
	public String reviewView() {
		return "thymeleaf/partner/mall/review/review_view";
	}
	@RequestMapping("reviewWrite")
	public String reviewWrite() {
		return "thymeleaf/partner/mall/review/review_write";
	}
	@RequestMapping("reviewModify")
	public String reviewModify() {
		return "thymeleaf/partner/mall/review/review_modify";
	}
	@RequestMapping("reviewDelete")
	public String reviewDelete() {
		return "thymeleaf/partner/mall/review/review_delete";
	}
}
