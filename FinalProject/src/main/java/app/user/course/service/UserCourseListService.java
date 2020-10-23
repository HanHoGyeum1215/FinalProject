package app.user.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.CourseDTO;
import app.admin.course.domain.StartEndPageDTO2;
import app.admin.course.mapper.CourseMapper;
import app.controller.PageAction;

@Component
@Service
public class UserCourseListService {
	@Autowired
	CourseMapper courseMapper;

	public void userCourseList(Integer page, String type, Model model) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		
		StartEndPageDTO2 startEndPageDTO = new StartEndPageDTO2(startRow,endRow);
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setStartEndPageDTO(startEndPageDTO);
		courseDTO.setGoodsType(type);

		List<CourseDTO> course = courseMapper.selectCourse(courseDTO);
		int count = courseMapper.courseCount();
		
		model.addAttribute("goods_lists", course);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "goodsList?");
	}

}
