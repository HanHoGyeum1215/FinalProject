package app.admin.intra.controller.commute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraCommuteCommand;
import app.admin.intra.service.commute.IntraCommuteListProService;
import app.admin.intra.service.commute.IntraCommuteListServie;
import app.admin.intra.service.commute.IntraCommuteWorkService;

@Controller
@RequestMapping("/admin/intra/commute")
public class IntraAdminCommuteController {

	@Autowired
	IntraCommuteListServie intraCommuteListServie;
	@Autowired
	IntraCommuteWorkService intraCommuteWorkService;
	@Autowired
	IntraCommuteListProService intraCommuteListProService;
	
	
	@RequestMapping("commuteList")
	public String commuteList(Model model)throws Exception {
		intraCommuteListServie.listService(model);
		return "thymeleaf/admin/intra/commute/commute_list";
	}
	@RequestMapping("commuteListPro")
	public String commuteListPro(@RequestParam(value="month")String comDate,Model model)throws Exception {
		intraCommuteListProService.intraCommuteListProService(comDate, model);
		return "thymeleaf/admin/intra/commute/commute_list";
	 }
 @RequestMapping("work")
 public String work(IntraCommuteCommand intraCommuteCommand, HttpSession session, 
		 HttpServletRequest request)throws Exception {
	 intraCommuteWorkService.goWork(intraCommuteCommand,session, request);
	 return "redirect:/admin/intra/commute/commuteList";
 }
 @RequestMapping("workOut")
 public String workOut(IntraCommuteCommand intraCommuteCommand, HttpSession session)throws Exception {
	 intraCommuteWorkService.outWork(intraCommuteCommand, session);
	 return "redirect:/admin/intra/commute/commuteList";
 }
 
}


