package app.admin.course.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.course.service.PaymentDetailService;
import app.admin.course.service.PaymentListService;

@Controller
@RequestMapping("admin/course/payment")
public class CourseAdminPaymentController {
	@Autowired
	PaymentListService paymentListService;
	@Autowired
	PaymentDetailService paymentDetailService;
	
	@RequestMapping("paymentList")
	public String paymentList(@RequestParam(value = "page" , defaultValue = "1")Integer page, Model model) throws Exception{
		paymentListService.paymentList(page,model);
		return "thymeleaf/admin/course/payment/payment_list";
	}
	@RequestMapping("paymentView")
	public String paymentView(@RequestParam(value="payNo") Long payNo, Model model)  throws Exception{
		paymentDetailService.paymentDetail(payNo, model);
		return "thymeleaf/admin/course/payment/payment_view";
	}
}
