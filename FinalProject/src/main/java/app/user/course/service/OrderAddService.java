package app.user.course.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.mapper.CourseMapper;
import app.command.AuthInfo;
import app.user.course.command.OrderCommand;
import app.user.course.domain.CartDTO;
import app.user.course.domain.OrderDTO;

@Component
@Service
public class OrderAddService {
	@Autowired
	CourseMapper courseMapper;

	public void orderAdd(OrderCommand orderCommand, HttpSession session, Model model) throws Exception{
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		  String userId = authInfo.getId();
		  
		  OrderDTO order = new OrderDTO();
		  order.setMemId(userId);
		  order.setVenId(orderCommand.getVenId());
		  order.setOrderAddr(orderCommand.getOrderAddr());
		  order.setOrderMsg(orderCommand.getOrderMsg());
		  
		  CartDTO dto = new CartDTO();
		  dto.setMemId(userId);
		  
		  List<CartDTO> cart = courseMapper.cartList(dto);
		  Long sumTotalPrice=0L;
		  String goodsNo = "";
		  for (CartDTO c : cart) {
			  sumTotalPrice+=c.getCartPrice();
			  goodsNo = c.getGoodsNo() + "000";
			  
		  }

	      order.setOrderPrice(sumTotalPrice);
	      order.setGoodsNo(goodsNo);
	      
	      
          Integer i = courseMapper.goodsOrder(order);
          if(i != null) {
        	  
        	  OrderDTO orderList = courseMapper.selectOrder(order).get(0);
        	  
//        	  String [] goodsNo1 = orderList.getGoodsNo().split("000");
//              List<OrderDTO> goodsNumbers=new ArrayList<OrderDTO>();
//              
//              for (String goods : goodsNo1) {
//                 OrderDTO goodsNum= new OrderDTO(goods);
//                 goodsNumbers.add(goodsNum);
//              }

        	  
        	  model.addAttribute("orderList",orderList);
        	  model.addAttribute("total_price",sumTotalPrice);
//        	  model.addAttribute("goodsNumbers",goodsNumbers);
        	  
          }
          
		
	}

}
