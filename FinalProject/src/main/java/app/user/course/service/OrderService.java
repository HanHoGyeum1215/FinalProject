package app.user.course.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.mapper.CourseMapper;
import app.user.course.domain.CartDTO;

@Component
@Service
public class OrderService {
	@Autowired
	CourseMapper courseMapper;

	public void goodsOrder(Long cartNo, HttpSession session, Model model) throws Exception{
		CartDTO cart = new CartDTO();
		cart.setCartNo(cartNo);
//		cart = courseMapper.selectCart(cart).get(0);
				
		model.addAttribute("order", cart);

	}

}
