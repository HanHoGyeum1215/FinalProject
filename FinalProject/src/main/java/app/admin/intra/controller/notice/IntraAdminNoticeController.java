package app.admin.intra.controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.service.notice.IntraNoticeDeleteProService;
import app.admin.intra.service.notice.IntraNoticeDetailService;
import app.admin.intra.service.notice.IntraNoticeListService;
import app.admin.intra.service.notice.IntraNoticeModifyProService;
import app.admin.intra.service.notice.IntraNoticeModifyService;
import app.admin.intra.service.notice.IntraNoticeService;
import app.controller.FileDownLoad;

@Controller
@RequestMapping("/admin/intra/notice")
public class IntraAdminNoticeController {
	
	@Autowired
	IntraNoticeService intraNoticeService;
	@Autowired
	IntraNoticeListService intraNoticeListService;
	@Autowired
	IntraNoticeDetailService intraNoticeDetailService;
	@Autowired
	IntraNoticeModifyService intraNoticeModifyService;
	@Autowired
	IntraNoticeModifyProService intraNoticeModifyProService;
	@Autowired
	IntraNoticeDeleteProService intraNoticeDeleteProService;
    @Autowired 
    FileDownLoad fileDownLoad;

	
	@RequestMapping("noticeList")//리스트 페이지
	public String noticeList(@RequestParam(value= "page",defaultValue = "1")int page,Model model)throws Exception {
		intraNoticeListService.listService(page,model);
		return "thymeleaf/admin/intra/notice/notice_list";
	}
	@RequestMapping("noticeWrite")//라이트 페이지
	public String noticeWrite()throws Exception{
		return "thymeleaf/admin/intra/notice/notice_write";
	}
	@RequestMapping(value = "noticeWritePro", method = RequestMethod.POST)//라이트페이지에서 작성 후 저장//저장 하기 위해서는 id를 세션으로 가져와야함
	public String noticeWritePro(IntraNoticeCommand intraNoticeCommand, HttpSession session)throws Exception{
		intraNoticeService.execute(intraNoticeCommand, session);
		return "redirect:/admin/intra/notice/noticeList";
	}
	@RequestMapping(value = "noticeView")//상세 페이지  게시글 번호를 가져와 해당 게시글 표기
	public String noticeView(@RequestParam(value = "num")Integer notNo,Model model)throws Exception {
		intraNoticeDetailService.intraNoticeDetailService(notNo, model);
		return "thymeleaf/admin/intra/notice/notice_view";
	}
	@RequestMapping("noticeModify")//수정페이지
	public String noticeModify(@RequestParam(value = "num")Integer notNo,Model model)throws Exception{
		intraNoticeDetailService.intraNoticeDetailService(notNo, model);
		return "thymeleaf/admin/intra/notice/notice_modify";
	}
	@RequestMapping(value = "NoticeModifyPro", method=RequestMethod.POST)//수정 후 해당 게시글 상세 페이지
	public String NoticeModifyPro(IntraNoticeCommand intraNoticeCommand)throws Exception{
		intraNoticeModifyProService.IntraNoticeUpdate(intraNoticeCommand);
		return "redirect:/admin/intra/notice/noticeView?num="+intraNoticeCommand.getNotNo();
	}
	@RequestMapping("noticedelete")//삭제 페이지 
	public String noticedelete(@RequestParam(value = "num") Integer notNo)
			 throws Exception {
		return "thymeleaf/admin/intra/notice/notice_delete";
	}
	@RequestMapping("noticeDeletePro")//삭제 후 리스트 페이지
	public String noticeDeletePro(@RequestParam(value = "num") Integer notNo)
		 throws Exception {
		intraNoticeDeleteProService.NoticeDel(notNo);
		return "redirect:/admin/intra/notice/noticeList";
	
		//모든 행위는 다음 페이지에서 이루어진다.writepage,modifypage,deletepage 이후 페이지 이동시 적용
	
	}
	
	@RequestMapping("fileDown")
	public void filDownLoad(@RequestParam(value = "sfile") String notStoreFile ,
			@RequestParam(value = "ofile") String notOriginFile, 
			HttpServletResponse response, HttpServletRequest request) {
		fileDownLoad.fileDownLoad("/static/notice/upload",notStoreFile,notOriginFile,request,response);
	}
}
