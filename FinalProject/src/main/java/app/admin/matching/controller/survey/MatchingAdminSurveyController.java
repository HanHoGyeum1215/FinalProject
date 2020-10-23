package app.admin.matching.controller.survey;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.admin.matching.command.SurveyCommand;
import app.admin.matching.service.SurveySearchService;
import app.admin.matching.service.SurveyWriteService;

@Controller
@RequestMapping("/admin/matching/survey")
public class MatchingAdminSurveyController {
	@Autowired
	SurveyWriteService surveyWriteService;
	@Autowired
	SurveySearchService surveySearchService;
	@RequestMapping("surveyWrite")
	public String surveyWrite() {
		return "thymeleaf/admin/matching/survey/survey_write";
	}
	
	@RequestMapping("surveyWritePro")
	public String surveyWritePro(SurveyCommand surveyCommand, Model model, HttpSession session) throws Exception {
		String memId=surveyWriteService.execute(surveyCommand,model,session);
		 surveySearchService.execute(memId, model);
		return "thymeleaf/admin/matching/survey/survey_result";
	}
	
}
