package app.partner.mall.controller.goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/partner/mall/goods")
public class MallPartnerGoodsController {
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/partner/mall/goods/goods_list";
	}
	@RequestMapping("goodsView")
	public String goodsView() {
		return "thymeleaf/partner/mall/goods/goods_view";
	}
	@RequestMapping("goodsWrite")
	public String goodsWrite() {
		return "thymeleaf/partner/mall/goods/goods_write";
	}
	@RequestMapping("goodsModify")
	public String goodsModify() {
		return "thymeleaf/partner/mall/goods/goods_modify";
	}
	@RequestMapping("goodsDelete")
	public String goodsDelete() {
		return "thymeleaf/partner/mall/goods/goods_delete";
	}
}
