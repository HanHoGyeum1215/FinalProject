package app.admin.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.MemberDTO2;
import app.admin.course.domain.StartEndPageDTO2;
import app.admin.course.mapper.MemberMapper2;
import app.controller.PageAction;

@Component
@Service
public class MemberListService2 {
	@Autowired
	MemberMapper2 memberMapper;

	public void memberList(Model model, Integer page) throws Exception{
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long)page -1 ) * 10 +1;
		Long endRow = startRow + limit -1;
		
		StartEndPageDTO2 startEndPageDTO = new StartEndPageDTO2(startRow,endRow);
		MemberDTO2 memberDTO = new MemberDTO2();
		memberDTO.setStartEndPageDTO(startEndPageDTO);

		List<MemberDTO2> members = memberMapper.selectMember(memberDTO);
		int count = memberMapper.memberCount();
		
		model.addAttribute("lists", members);
		model.addAttribute("count", count);
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "memberList?");
	}

}
