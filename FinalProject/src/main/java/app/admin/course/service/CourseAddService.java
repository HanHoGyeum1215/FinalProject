package app.admin.course.service;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import app.admin.course.command.CourseCommand;
import app.admin.course.domain.CourseDTO;
import app.admin.course.mapper.CourseMapper;

@Component
@Service
public class CourseAddService {
	@Autowired
	CourseMapper courseMapper;

	public void courseAdd(CourseCommand courseCommand, HttpServletRequest request, Model model) throws Exception{
		HttpSession session = request.getSession();
		CourseDTO course = new CourseDTO();
		course.setVenId(courseCommand.getVenId());
		course.setGoodsType(courseCommand.getGoodsType());
		course.setGoodsNo(courseCommand.getGoodsNo());
		course.setGoodsName(courseCommand.getGoodsName());
		course.setGoodsPrice(courseCommand.getGoodsPrice());
		course.setGoodsDet(courseCommand.getGoodsDet().replace("\r\n", "<br>"));
//		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
//		dto.setUserId(authInfo.getUserId());
//		dto.setIpAddr(request.getRemoteAddr());
		String path = "/static/upload/course";
		String filePath = session.getServletContext().getRealPath(path);
		String goodsImage = "";
		for(MultipartFile mf : courseCommand.getGoodsImage()) {
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
			goodsImage += store;
			File file = new File(filePath + "\\" + store);
			try {mf.transferTo(file); 
			} catch (Exception e) { e.printStackTrace();}			
		}
		course.setGoodsImage(goodsImage);
		courseMapper.courseInsert(course);		
//		String location = "";
//		location = "redirect:/admin/course/partner/partnerCourseAdd?id="+courseCommand.getVenId();
//		return location;
	}



}
