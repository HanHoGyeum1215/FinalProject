package app.user.mall.controller.goods;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mall/goods")
public class MallGoodsController {
	@RequestMapping("goodsList")
	public String goodsList() {
		return "thymeleaf/mall/goods/goods_list";
	}
	@RequestMapping("goodsView")
	public String goodsView() {
		return "thymeleaf/mall/goods/goods_view";
	}
	@RequestMapping("cart")
	public String goodsCart() {
		return "thymeleaf/mall/goods/goods_cart";
	}
	@RequestMapping("order")
	public String goodsOrder() {
		return "thymeleaf/mall/goods/goods_order";
	}
}
