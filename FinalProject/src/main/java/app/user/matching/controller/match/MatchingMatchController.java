package app.user.matching.controller.match;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.admin.matching.command.MatchPayCommand;
import app.admin.matching.service.MatchPayWriteService;
import app.admin.matching.service.MemberAddUpdateService;
import app.admin.matching.service.MemberDetailService;
import app.command.AuthInfo;

@Controller
@RequestMapping("matching/match")
public class MatchingMatchController {
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	MatchPayWriteService matchPayWriteService;
	@Autowired
	MemberAddUpdateService memberAddUpdateService;
	@RequestMapping("payment")
	public String matchPay() {
		return "thymeleaf/matching/match/payment";
		
	}
	@RequestMapping("order")
	public String matchOrder(HttpServletResponse response,HttpSession session,Model model) throws Exception {
		String memId=((AuthInfo)session.getAttribute("authInfo")).getId();
		String expDate=memberDetailService.memberDetail(model, memId);
		
		if (expDate!=null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 유료 서비스에 가입되어 있습니다.'); location.href='/matching/survey/surveyWrite';</script>");
			out.flush();
		}
		
		return "thymeleaf/matching/match/match_order";
	}
	@RequestMapping("orderPro")
	public String orderPro(MatchPayCommand matchPayCommand) throws Exception {
		matchPayWriteService.execute(matchPayCommand);
		memberAddUpdateService.execute(matchPayCommand);
		return "redirect:/";
				
	}
	
}
