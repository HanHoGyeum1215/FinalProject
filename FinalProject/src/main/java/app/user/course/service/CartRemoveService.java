package app.user.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.course.mapper.CourseMapper;
import app.user.course.domain.CartDTO;

@Service
@Component
public class CartRemoveService {
	@Autowired
	CourseMapper courseMapper;
	public void execute(Long cartNo, String goodsNo) {
		CartDTO dto=new CartDTO();
		dto.setCartNo(cartNo);
		dto.setGoodsNo(goodsNo);
		courseMapper.cartGoodsDel(dto);
	}

}
