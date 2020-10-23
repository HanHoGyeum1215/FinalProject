package app.admin.matching.controller.match;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.matching.command.MatchCommand;
import app.admin.matching.service.MatchDetailService;
import app.admin.matching.service.MatchListService;
import app.admin.matching.service.MatchModifyService;
import app.admin.matching.service.MatchWriteService;

@Controller
@RequestMapping("/admin/matching/match")
public class MatchingAdminMatchController {
	@Autowired
	MatchWriteService matchWriteService;
	@Autowired
	MatchListService matchListService;
	@Autowired
	MatchDetailService matchDetailService;
	@Autowired
	MatchModifyService matchModifyService;
	

	@RequestMapping("matchView")
	public String matchView(@RequestParam(value = "matNo") String matNo,@RequestParam(value = "id", required = false) String partnerId, Model model) throws Exception{
		matchDetailService.execute(matNo,partnerId,model);
		return "thymeleaf/admin/matching/match/match_view";
	}

	@RequestMapping("matchWrite")
	public String matchWrite() {
		return "thymeleaf/admin/matching/match/match_write";
	}

	
	@RequestMapping(value = "matchWritePro", method = RequestMethod.POST)
	public String matchWritePro(@Validated MatchCommand matchCommand, BindingResult result, HttpServletRequest request)
			throws Exception {

		if (result.hasErrors()) {
			System.out.println("에러");
			return "thymeleaf/admin/matching/match/match_write";
		}

		String location = matchWriteService.matchWrite(matchCommand, request);
		return location;
	}

	@RequestMapping("matchModify")
	public String matchModify(@RequestParam(value = "matNo") String matNo, Model model) throws Exception{
		matchDetailService.execute(matNo, null, model);
		return "thymeleaf/admin/matching/match/match_modify";
	}
	@RequestMapping(value = "matchModifyPro", method = RequestMethod.POST)
	public String matchModifyPro(@Validated MatchCommand matchcommand, Model model) throws Exception{
		matchModifyService.execute(matchcommand, model);
		return "redirect:/admin/matching/match/matchView?matNo="+matchcommand.getMatNo()+"&id="+matchcommand.getPartnerId();
	}
	
	@RequestMapping("matchList")
	public String matchList(@RequestParam(value = "page", defaultValue = "1")Integer page, Model model) throws Exception {
		matchListService.execute(model,page);
		return "thymeleaf/admin/matching/match/match_list";
	}
}
