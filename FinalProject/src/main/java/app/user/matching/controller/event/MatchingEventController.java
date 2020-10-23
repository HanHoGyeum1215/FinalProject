package app.user.matching.controller.event;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.mapper.EventMapper;
import app.admin.matching.service.EventDetailService;
import app.admin.matching.service.EventJoinService;
import app.admin.matching.service.EventListService;
import app.admin.matching.service.MemberDetailService;
import app.command.AuthInfo;

@Controller
@RequestMapping("matching/event")
public class MatchingEventController {
	@Autowired
	EventListService eventListService;
	@Autowired
	EventDetailService eventDetailService;
	@Autowired
	MemberDetailService memberDetailService;
	@Autowired
	EventJoinService eventJoinService;
	@RequestMapping("eventList")
	public String eventList(@RequestParam(value = "page" , defaultValue = "1") Integer page, Model model) throws Exception {
		eventListService.execute(model,page);
		return "thymeleaf/matching/event/event_list";
		
	}
	@RequestMapping("eventView")
	public String eventView(@RequestParam(value = "eveNo")String eveNo,Model model, HttpSession session, HttpServletResponse response) throws Exception {
		if (session.getAttribute("authInfo")==null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('먼저 로그인을 해주세요'); location.href='/login';</script>");
			out.flush();
		}
		
		eventDetailService.execute(eveNo, model);
		return "thymeleaf/matching/event/event_view";
	}
	
	@RequestMapping("eventJoin")
	public String eventJoin(@RequestParam(value = "eveNo")String eveNo, Model model, HttpSession session) throws Exception {
		eventDetailService.execute(eveNo, model);
		String memId=((AuthInfo)session.getAttribute("authInfo")).getId();
		memberDetailService.memberDetail(model, memId);
		return "thymeleaf/matching/event/event_join";
	}
	@RequestMapping(value = "eventJoinPro", method = RequestMethod.POST)
	public String eventJoinPro(@RequestParam(value = "eveNo")String eveNo, @RequestParam(value = "memId")String memId, HttpServletResponse response) throws Exception {
		eventJoinService.execute(eveNo,memId, response);
		eventJoinService.appUpdate(eveNo);
		return "redirect:/matching/event/eventList";
	}
}
