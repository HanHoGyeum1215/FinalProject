package app.user.course.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("course")
public class CourseMainController {
	@RequestMapping("/")
	public String home() {
		return "thymeleaf/course/index";
	}
	
}
