package app.user.course.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.CourseDTO;
import app.admin.course.mapper.CourseMapper;
import app.command.AuthInfo;
import app.user.course.domain.CartDTO;

@Component
@Service
public class CartAddService {
	@Autowired
	CourseMapper courseMapper;
	
			public void cartAdd(String goodsNo, HttpSession session, Model model) throws Exception{
				// 장바구니에 상품을 담기 위해서 먼저 상품정보를 가져와야 한다.
				CourseDTO dto = new CourseDTO();
				dto.setGoodsNo(goodsNo);
				dto = courseMapper.selectCourse(dto).get(0);
				CartDTO cart = new CartDTO();
				String [] imgs = dto.getGoodsImage().split("`");
				cart.setGoodsImage(imgs[0]);
				cart.setGoodsImage(dto.getGoodsImage());
				cart.setGoodsName(dto.getGoodsName());
				cart.setGoodsNo(dto.getGoodsNo());
				cart.setGoodsPrice(dto.getGoodsPrice());
				cart.setVenId(dto.getVenId());
				AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
				String userId = authInfo.getId();
//				if(userId == null) {
//					userId = "dbsgywjd";
//				}
				cart.setMemId(userId);
				courseMapper.goodsCartAdd(cart);			
				
//				model.addAttribute("cart", i);
			}

}
