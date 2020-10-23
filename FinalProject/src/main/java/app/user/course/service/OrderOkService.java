package app.user.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.mapper.CourseMapper;
import app.user.course.command.OrderCommand;
import app.user.course.domain.OrderDTO;

@Component
@Service
public class OrderOkService {
	@Autowired
	CourseMapper courseMapper;

	public void orderOk(OrderCommand orderCommand, Model model) {
		OrderDTO order = new OrderDTO();
		
	}

}
