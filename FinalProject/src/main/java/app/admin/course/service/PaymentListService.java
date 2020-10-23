package app.admin.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.StartEndPageDTO2;
import app.admin.course.mapper.CourseMapper;
import app.controller.PageAction;
import app.user.course.domain.OrderDTO;

@Component
@Service
public class PaymentListService {
	@Autowired
	CourseMapper courseMapper;

	public void paymentList(Integer page, Model model) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		
		StartEndPageDTO2 startEndPageDTO = new StartEndPageDTO2(startRow,endRow);
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setStartEndPageDTO(startEndPageDTO);

		List<OrderDTO> payment = courseMapper.selectOrder(orderDTO);
		int count = courseMapper.orderCount();
		
		model.addAttribute("payment_list", payment);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "paymentList?");		
	}

}
