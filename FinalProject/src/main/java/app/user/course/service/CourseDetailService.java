package app.user.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.CourseDTO;
import app.admin.course.mapper.CourseMapper;

@Component
@Service
public class CourseDetailService {
	@Autowired
	CourseMapper courseMapper;

	public void courseDetail(String venId, Model model, String goodsNo) throws Exception{
		CourseDTO course = new CourseDTO();
		
		course.setGoodsNo(goodsNo);
	 	course.setVenId(venId);
	 	course = courseMapper.selectCourse(course).get(0);
//	 	course.setGoodsDet(course.getGoodsDet().replace("\r\n", "<br>"));
	 	String imgs = course.getGoodsImage();
	 	course.setGoodsImage(imgs);
		model.addAttribute("courseCommand", course);			
	}

}
