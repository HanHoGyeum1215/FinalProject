package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.mapper.CourseMapper;
import app.user.course.domain.OrderDTO;

@Component
@Service
public class PaymentDetailService {
	@Autowired
	CourseMapper courseMapper;

	public void paymentDetail(Long payNo, Model model) throws Exception{

		OrderDTO order = new OrderDTO();
		
		order.setOrderNo(payNo);
		order = courseMapper.selectOrder(order).get(0);
		model.addAttribute("orderCommand", order);	
	}

}
