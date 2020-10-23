package app.user.course.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.mapper.CourseMapper;
import app.command.AuthInfo;
import app.user.course.domain.CartDTO;

@Component
@Service
public class CartListService {
	@Autowired
	CourseMapper courseMapper;

	public void cartList(HttpSession session, Model model) throws Exception{
		  AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		  String userId = authInfo.getId();
		  
		  CartDTO dto = new CartDTO();
		  dto.setMemId(userId);
		  

	      List<CartDTO> list=courseMapper.cartList(dto);
	      Long sumTotalPrice=0L;
	      String venId="";
	      Long cartNo=0L;
	      for (CartDTO c : list) {
	         sumTotalPrice+=c.getCartPrice();
	         cartNo = c.getCartNo();
	         venId = c.getVenId();
	      }
	      
	      model.addAttribute("memId",userId);
	      model.addAttribute("venId",venId);
	      model.addAttribute("cartList",list);
	      model.addAttribute("sumTotalPrice",sumTotalPrice);
	      model.addAttribute("cartNo",cartNo);
	      
	      
	}

	public void cartQtyDown(String goodsNo,HttpSession session) throws Exception{
		  AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		  String userId = authInfo.getId();
		  CartDTO cartDTO=new CartDTO();
		  cartDTO.setMemId(userId);
		  cartDTO.setGoodsNo(goodsNo);
		  System.out.println(cartDTO.getMemId());
		  System.out.println(cartDTO.getGoodsNo());
		  courseMapper.qtyDown(cartDTO);
		
	}
	

}
