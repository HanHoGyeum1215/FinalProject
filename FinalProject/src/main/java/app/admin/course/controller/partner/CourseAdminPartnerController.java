package app.admin.course.controller.partner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.course.command.CourseCommand;
import app.admin.course.command.PartnerCommand;
import app.admin.course.service.CourseAddService;
import app.admin.course.service.CourseListService;
import app.admin.course.service.PartnerDeleteService;
import app.admin.course.service.PartnerDetailService;
import app.admin.course.service.PartnerJoinService;
import app.admin.course.service.PartnerListService;

@Controller
@RequestMapping("/admin/course/partner")
public class CourseAdminPartnerController {
	@Autowired
	PartnerListService partnerListService;
	@Autowired
	PartnerJoinService partnerJoinService;
	@Autowired
	PartnerDetailService partnerDetailService;
	@Autowired
	PartnerDeleteService partnerDeleteService;
	@Autowired
	CourseAddService courseAddService;
	@Autowired
	CourseListService courseListService;
	
	@RequestMapping("partnerList")
	public String partnerList(@RequestParam(value = "page" , defaultValue = "1")Integer page, Model model) throws Exception{
		partnerListService.partnerList(model,page);
		return "thymeleaf/admin/course/partner/partner_list";
	}

	@RequestMapping("partnerWrite")
	public String partnerWrite() {
		return "thymeleaf/admin/course/partner/partner_write";
	}
	
	@RequestMapping(value = "partnerJoinOk", method = RequestMethod.POST)
	public String partnerJoinOk(@Validated PartnerCommand partnerCommand, BindingResult result, Model model) throws Exception{
		if (result.hasErrors()) {
			return "thymeleaf/admin/course/partner/partner_write";
		}
		Integer i = partnerJoinService.insertPartner(partnerCommand,model);
		if( i == null) return "thymeleaf/admin/course/partner/partner_write";
		return "redirect:/admin/course/partner/partnerList";
	}
	
	@RequestMapping(value = "partnerView", method = RequestMethod.GET)
	public String partnerView(@RequestParam(value="id") String venId, Model model)  throws Exception{
		partnerDetailService.partnerDetail(venId, model);
		return "thymeleaf/admin/course/partner/partner_view";
	}
	@RequestMapping(value = "partnerDelete", method = RequestMethod.GET)
	public String partnerDelete(@RequestParam(value="id") String venId) throws Exception{
		partnerDeleteService.partnerDelete(venId);
		return "thymeleaf/admin/course/partner/partner_delete";
	}
	
	@RequestMapping(value = "partnerCourseAdd", method = RequestMethod.GET)
	public String partnerCourseAdd(@RequestParam(value="id") String venId, Model model) throws Exception{
		partnerDetailService.partnerDetail(venId, model);
		courseListService.courseList(venId,model);
		return "thymeleaf/admin/course/partner/partner_course";
		
	}
	
	@RequestMapping(value = "courseAddOk", method = RequestMethod.POST)
	public String courseAddOk(@Validated CourseCommand courseCommand, BindingResult result, HttpServletRequest request, Model model) throws Exception{
		courseAddService.courseAdd(courseCommand,request,model);
//		return location;
		return "redirect:/admin/course/partner/partnerCourseAdd?id="+courseCommand.getVenId();
	}
	
	@RequestMapping("partnerModify")
	public String partnerModify() {
		return "thymeleaf/admin/course/partner/partner_modify";
	}
}
