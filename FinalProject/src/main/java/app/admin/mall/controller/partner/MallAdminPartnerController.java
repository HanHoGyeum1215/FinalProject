package app.admin.mall.controller.partner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/mall/partner")
public class MallAdminPartnerController {
	@RequestMapping("partnerList")
	public String partnerList() {
		return "thymeleaf/admin/mall/partner/partner_list";
	}
	@RequestMapping("partnerView")
	public String partnerView() {
		return "thymeleaf/admin/mall/partner/partner_view";
	}
	@RequestMapping("partnerWrite")
	public String partnerWrite() {
		return "thymeleaf/admin/mall/partner/partner_write";
	}
	@RequestMapping("partnerModify")
	public String partnerModify() {
		return "thymeleaf/admin/mall/partner/partner_modify";
	}
	@RequestMapping("partnerDelete")
	public String partnerDelete() {
		return "thymeleaf/admin/mall/partner/partner_delete";
	}
}
