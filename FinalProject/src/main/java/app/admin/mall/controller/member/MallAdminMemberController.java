package app.admin.mall.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mall/member")
public class MallAdminMemberController {
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/admin/mall/member/member_list";
	}
	@RequestMapping("memberView")
	public String memberView() {
		return "thymeleaf/admin/mall/member/member_view";
	}
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "thymeleaf/admin/mall/member/member_write";
	}
	@RequestMapping("memberModify")
	public String memberModify() {
		return "thymeleaf/admin/mall/member/member_modify";
	}
	@RequestMapping("memberDelete")
	public String memberDelete() {
		return "thymeleaf/admin/mall/member/member_delete";
	}
	
}