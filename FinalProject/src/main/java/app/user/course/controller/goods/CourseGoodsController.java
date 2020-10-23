package app.user.course.controller.goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.user.course.command.OrderCommand;
import app.user.course.service.CartAddService;
import app.user.course.service.CartListService;
import app.user.course.service.CartRemoveService;
import app.user.course.service.CourseDetailService;
import app.user.course.service.OrderAddService;
import app.user.course.service.UserCourseListService;


@Controller
@RequestMapping("course/goods")
public class CourseGoodsController {
    @Autowired
    UserCourseListService userCourseListService;
    @Autowired
    CourseDetailService courseDetailService;
    @Autowired
    CartAddService cartAddService;
    @Autowired
    CartListService cartListService;
    @Autowired
    OrderAddService orderAddService;
    @Autowired
    CartRemoveService cartRemoveService;
    
	@RequestMapping("goodsList")
	public String goodsList(@RequestParam(value = "page" , defaultValue = "1")Integer page, @RequestParam(value="type") String type, Model model) throws Exception{
		userCourseListService.userCourseList(page,type,model);
		return "thymeleaf/course/goods/course_list";
	}	

	@RequestMapping(value = "goodsView", method = RequestMethod.GET)
	public String goodsView(@RequestParam(value="id") String venId, @RequestParam(value = "goodsNo") String goodsNo,Model model)  throws Exception{
		courseDetailService.courseDetail(venId, model,goodsNo);
		return "thymeleaf/course/goods/course_view";
	}
	
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String goodsCart(@RequestParam(value="goodsNo") String goodsNo, HttpSession session, Model model)  throws Exception{
		cartAddService.cartAdd(goodsNo, session, model);
		cartListService.cartList(session, model);
		return "thymeleaf/course/goods/course_cart";
	}
	
	@RequestMapping("cartQtyDown")
	public String cartQtyDown(@RequestParam(value = "goodsNo")String goodsNo,HttpSession session,Model model)  throws Exception{
		cartListService.cartQtyDown(goodsNo,session);
		cartListService.cartList(session, model);
		return "thymeleaf/course/goods/course_cart";
	}
	
	@RequestMapping(value = "order", method = RequestMethod.GET)
	public String goodsOrder(@Validated OrderCommand orderCommand, BindingResult result,HttpSession session, Model model)  throws Exception{
		cartListService.cartList(session, model);
		return "thymeleaf/course/goods/course_order";
	}
	
	@RequestMapping("orderOk")
	public String orderOk(@Validated OrderCommand orderCommand, BindingResult result, HttpSession session, Model model)  throws Exception{
		cartListService.cartList(session, model);
		orderAddService.orderAdd(orderCommand, session, model);
		return "thymeleaf/course/goods/order_ok";
	}
	@RequestMapping("cartRemove")
	public String cartRemove(@RequestParam(value = "cartNo")Long cartNo, @RequestParam(value = "goodsNo") String goodsNo, HttpSession session, Model model) throws Exception {
		cartRemoveService.execute(cartNo,goodsNo);
		cartListService.cartList(session, model);
		return "thymeleaf/course/goods/course_cart";
	}
}












