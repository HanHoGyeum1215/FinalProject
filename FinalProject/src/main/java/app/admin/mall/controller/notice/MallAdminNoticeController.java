package app.admin.mall.controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mall/notice")
public class MallAdminNoticeController {
	@RequestMapping("noticeList")
	public String noticeList() {
		return "thymeleaf/admin/mall/notice/notice_list";
	}
	@RequestMapping("noticeView")
	public String noticeView() {
		return "thymeleaf/admin/mall/notice/notice_view";
	}
	@RequestMapping("noticeWrite")
	public String noticeWrite() {
		return "thymeleaf/admin/mall/notice/notice_write";
	}
	@RequestMapping("noticeModify")
	public String noticeModify() {
		return "thymeleaf/admin/mall/notice/notice_modify";
	}
	@RequestMapping("noticeDelete")
	public String noticeDelete() {
		return "thymeleaf/admin/mall/notice/notice_delete";
	}
}
