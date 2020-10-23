package app.admin.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.CourseDTO;
import app.admin.course.mapper.CourseMapper;

@Component
@Service
public class CourseListService {
	@Autowired
	CourseMapper courseMapper;

	public void courseList(String venId,Model model) throws Exception{
		CourseDTO courseDTO = new CourseDTO();
		courseDTO.setVenId(venId);
		List<CourseDTO> course = courseMapper.selectCourse(courseDTO);
		model.addAttribute("c_lists", course);		
		
	}

}
