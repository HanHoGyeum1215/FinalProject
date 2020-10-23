package app.admin.course.mapper;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.course.domain.CourseDTO;
import app.user.course.domain.CartDTO;
import app.user.course.domain.OrderDTO;

@Component
@Repository(value = "app.admin.course.mapper.CourseMapper")
public interface CourseMapper {
	public void courseInsert(CourseDTO courseDTO)throws Exception;
	public List<CourseDTO> selectCourse(CourseDTO courseDTO) throws Exception;	
	public Integer courseCount();	
	public void goodsCartAdd(CartDTO cartDTO)throws Exception;	
	public List<CartDTO> cartList(CartDTO cartDTO)throws Exception;	
	public Integer goodsOrder(OrderDTO orderDTO)throws Exception;	
	public List<OrderDTO> selectOrder(OrderDTO orderDTO)throws Exception;	
	public Integer orderCount();	
	public void qtyDown(CartDTO cartDTO);	
	public void cartGoodsDel(CartDTO dto);
//	public Integer courseDelete(String venId)throws Exception;
}
