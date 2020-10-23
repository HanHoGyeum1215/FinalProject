package app.user.mall.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mall/board")
public class MallReviewController {
	@RequestMapping("reviewList")
	public String reviewList() {
		return "thymeleaf/mall/review/review_list";
	}
	@RequestMapping("reviewView")
	public String reviewView() {
		return "thymeleaf/mall/review/review_view";
	}
	@RequestMapping("reviewWrite")
	public String reviewWrite() {
		return "thymeleaf/mall/review/review_write";
	}
	@RequestMapping("reviewModify")
	public String reviewModify() {
		return "thymeleaf/mall/review/review_modify";
	}
	@RequestMapping("reviewDelete")
	public String reviewDelete() {
		return "thymeleaf/mall/review/review_delete";
	}
}
