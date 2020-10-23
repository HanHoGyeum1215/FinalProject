package app.user.matching.controller.survey;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.admin.matching.command.SurveyCommand;
import app.admin.matching.service.SurveySearchService;
import app.admin.matching.service.SurveyWriteService;

@Controller
@RequestMapping("matching/survey")
public class MatchingSurveyController {
	@Autowired
	SurveyWriteService surveyWriteService;
	@Autowired
	SurveySearchService surveySearchService;
	
	@RequestMapping("surveyWrite")
	public String surveyWrite() {
		return "thymeleaf/matching/survey/survey_write";
	}
	@RequestMapping("surveyWritePro")
	public String surveyWritePro(SurveyCommand surveyCommand, Model model, HttpSession session, HttpServletResponse response) throws Exception {
		if (session.getAttribute("authInfo")==null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('먼저 로그인을 해주세요'); location.href='/login';</script>");
			out.flush();
		}
		
		String memId=surveyWriteService.execute(surveyCommand,model,session);
		surveySearchService.execute(memId, model);
		
		return "thymeleaf/matching/survey/survey_result";
	}
	
	
	@RequestMapping("memberList")
	public String memberList() {
		return "thymeleaf/matching/survey/member_list";
	}
}
