package app.admin.matching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Service
@Component
public class MemberListService {
	@Autowired
	MemberMapper memberMapper;

	public void memberList(Model model, Integer page) throws Exception {
		int limit = 10;
		int limitPage = 10;

		Long startRow = ((long) page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow, endRow);

		List<MemberDTO> list = memberMapper.selectMember(startEndPageDTO);
		int count = memberMapper.getMemberCount(null);

		model.addAttribute("memberList", list);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
			pageAction.page(model, count, limit, limitPage, page, "memberList?");

	}
	
	public void paidMemberList(Model model,Integer page) throws Exception {
		
		int limit = 10;
		int limitPage = 10;

		Long startRow = ((long) page - 1) * 10 + 1;
		Long endRow = startRow + limit - 1;
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(startRow, endRow);

		List<MemberDTO> list = memberMapper.selectPaidMember(startEndPageDTO);
		int count = memberMapper.getMemberCount("1");

		model.addAttribute("memberList", list);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
			pageAction.page(model, count, limit, limitPage, page, "List?");
		
	}

}
