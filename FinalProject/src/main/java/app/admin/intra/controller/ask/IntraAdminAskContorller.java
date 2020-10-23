package app.admin.intra.controller.ask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraAnswerCommand;
import app.admin.intra.command.IntraAskCommand;
import app.admin.intra.service.answer.IntraAnswerWriteProService;
import app.admin.intra.service.ask.IntraAskDetailService;
import app.admin.intra.service.ask.IntraAskListService;
import app.admin.intra.service.ask.IntraAskModifyProService;
import app.admin.intra.service.ask.IntraAskWriteService;
import app.admin.intra.service.ask.IntraDeleteProService;
import app.controller.FileDownLoad;

@Controller
@RequestMapping("/admin/intra/ask/")
public class IntraAdminAskContorller {
	
	@Autowired
	IntraAskWriteService intraAskWriteService;
	@Autowired
	IntraAskListService intraAskListService;
	@Autowired
	IntraAskDetailService intraAskDetailService;
	@Autowired
	IntraAskModifyProService intraAskModifyProService;
	 @Autowired 
	 FileDownLoad fileDownLoad;
	 @Autowired
	 IntraDeleteProService intraNoticeDeleteProService;
	
	@ModelAttribute
	IntraAnswerCommand setIntraAnswerCommand() {
		return new IntraAnswerCommand();
	}
	
	@RequestMapping("askList")
	public String askList(
				@RequestParam(value = "page", defaultValue = "1") int page, 
				Model model
			)throws Exception {
		intraAskListService.listServie(page, model);
		return "thymeleaf/admin/intra/ask/ask_list";
	}
	@RequestMapping("askWrite")
	public String askWrite() {
		return "thymeleaf/admin/intra/ask/ask_write";
	}
	@RequestMapping("askWritePro")
	public String askWritePro(IntraAskCommand intraAskCommand,HttpSession session)throws Exception {
		intraAskWriteService.askWrite(intraAskCommand,session);
		System.out.println(intraAskCommand);
		return "redirect:/admin/intra/ask/askList";
	}
	
	@RequestMapping("askView")
	public String askDetail(@RequestParam(value = "num")Integer askNo, Model model)throws Exception {
		intraAskDetailService.intraAskDetailService(askNo, model);
		return "thymeleaf/admin/intra/ask/ask_detail";
	}
	@Autowired
	IntraAnswerWriteProService intraAnswerWriteProService;
		@RequestMapping(value = "ansWritePro", method = RequestMethod.POST)
	public String ansWritePro(IntraAnswerCommand intraAnswerCommand,HttpSession session)throws Exception {
		intraAnswerWriteProService.answerWritePro(intraAnswerCommand, session);
		return "redirect:/admin/intra/ask/askView?num="+ intraAnswerCommand.getAskNo();
	}
		
		
	@RequestMapping("askModify")
	public String askModify(@RequestParam(value = "num")Integer askNo,Model model)throws Exception{
		intraAskDetailService.intraAskDetailService(askNo, model);
		return "thymeleaf/admin/intra/ask/ask_Modify";
	}
	@RequestMapping("AskModifyPro")
	public String AskModifyPro(IntraAskCommand intraAskCommand)throws Exception{
		intraAskModifyProService.intraAskModifyProService(intraAskCommand);
		return "redirect:/admin/intra/ask/askView?num="+intraAskCommand.getAskNo();
}
	@RequestMapping("askdelete")//삭제 페이지 
	public String askdelete(@RequestParam(value = "num") Integer askNo)
			 throws Exception {
		return "thymeleaf/admin/intra/ask/ask_delete";
		
	}
	@RequestMapping("askDeletePro")
	public String askdeletePro(@RequestParam(value = "num") Integer askNo)
			 throws Exception {
		intraNoticeDeleteProService.intraDeleteProService(askNo);
		return "redirect:/admin/intra/ask/askList";
	}
	@RequestMapping("fileDown")
	public void filDownLoad(@RequestParam(value = "sfile") String notStoreFile ,
			@RequestParam(value = "ofile") String notOriginFile, 
			HttpServletResponse response, HttpServletRequest request) {
		fileDownLoad.fileDownLoad("/static/ask/upload",notStoreFile,notOriginFile,request,response);
	
}
}
	