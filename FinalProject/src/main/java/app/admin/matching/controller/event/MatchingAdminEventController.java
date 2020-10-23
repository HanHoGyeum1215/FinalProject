package app.admin.matching.controller.event;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.EventCommand;
import app.admin.matching.domain.FileName;
import app.admin.matching.service.EventDelService;
import app.admin.matching.service.EventDetailService;
import app.admin.matching.service.EventListService;
import app.admin.matching.service.EventModifyService;
import app.admin.matching.service.EventWriteService;
import app.admin.matching.service.FileDelService;

@Controller
@RequestMapping("/admin/matching/event")
public class MatchingAdminEventController {
	@Autowired
	EventWriteService eventWriteService;
	@Autowired
	EventListService eventListService;
	@Autowired
	EventDetailService eventDetailService;
	@Autowired
	EventModifyService eventModifyService;
	@Autowired
	FileDelService fileDelService;
	@Autowired
	EventDelService eventDelService;

	@RequestMapping("eventWrite")
	public String eventWrite(EventCommand eventCommand) {
		return "thymeleaf/admin/matching/event/event_write";
	}

	@RequestMapping("eventWritePro")
	public String eventWritePro(@Validated EventCommand eventCommand, BindingResult result, Model model,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "thymeleaf/admin/matching/event/event_write";

		}
		String location = eventWriteService.insertEvent(eventCommand, model, request);

		return location;
	}

	@RequestMapping("eventList")
	public String eventList(@RequestParam(value = "page", defaultValue = "1") Integer page, Model model)
			throws Exception {
		eventListService.execute(model, page);
		return "thymeleaf/admin/matching/event/event_list";

	}

	@RequestMapping("eventView")
	public String eventView(@RequestParam(value = "eveNo") String eveNo, Model model) throws Exception {
		eventDetailService.execute(eveNo, model);
		return "thymeleaf/admin/matching/event/event_view";
	}

	@RequestMapping("eventModify")
	public String eventModify(@RequestParam(value = "eveNo") String eveNo, Model model) throws Exception {
		eventDetailService.execute(eveNo, model);
		return "thymeleaf/admin/matching/event/event_modify";
	}

	@RequestMapping("fileDel")
	public String fileDel(FileName fileName, HttpSession session, Model model) {
		fileDelService.fileSessionAdd(fileName, session, model);
		return "thymeleaf/admin/matching/event/delPage";
	}

	@RequestMapping("eventModifyPro")
	public String eventModifyPro(@RequestParam(value = "eveNo") String eveNo, HttpSession session,
			EventCommand eventCommand, HttpServletResponse response) throws Exception {
		Integer i = eventModifyService.execute(eveNo, session, eventCommand);
		if (i != 1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('권한이 없습니다.'); location.href='/admin/matching/event/eventList';</script>");
			out.flush();
		}
		return "redirect:/admin/matching/event/eventView?eveNo=" + eveNo;
	}

	@RequestMapping("eventDel")
	public String eventDel(@RequestParam(value = "eveNo") String eveNo, HttpSession session,
			HttpServletResponse response) throws Exception {
		Integer i = eventDelService.execute(eveNo, session);
		if (i!=1) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('권한이 없습니다.'); location.href='/admin/matching/event/eventList';</script>");
			out.flush();
		}

		return "redirect:/admin/matching/event/eventList";

	}

}
