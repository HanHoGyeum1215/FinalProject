package app.admin.matching.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.matching.command.MatchCommand;
import app.admin.matching.domain.MatchDTO;
import app.admin.matching.mapper.MatchMapper;
import app.command.AuthInfo;

@Service
@Component
public class MatchWriteService {
	@Autowired
	MatchMapper matchMapper;
	public String matchWrite(MatchCommand matchCommand, HttpServletRequest request) throws Exception{
		String location="";
		MatchDTO matchDTO=new MatchDTO();
		HttpSession session=request.getSession();
		AuthInfo authInfo=(AuthInfo)session.getAttribute("authInfo");
		matchDTO.setEmpId(authInfo.getId());//하드코딩
		matchDTO.setMatCheck(matchCommand.getMatCheck());
		System.out.println(matchDTO.getMatCheck());
		
		matchDTO.setMatDate(matchCommand.getMatDate());
		System.out.println(matchDTO.getMatDate());
		matchDTO.setMemId(matchCommand.getMemId());
		System.out.println(matchDTO.getMemId());
		matchDTO.setPartnerId(matchCommand.getPartnerId());
		System.out.println(matchDTO.getPartnerId());
		matchDTO.setMatLoc(matchCommand.getMatLoc());
		
		Integer i=matchMapper.memberMatchUpdate(matchDTO.getMemId());
		Integer j=matchMapper.memberMatchUpdate(matchDTO.getPartnerId());
		if (i==1 && j==1) {
			matchMapper.matchInsert(matchDTO);
		}else if(i==1 && j!=1){
			matchMapper.memberMatchUpdate2(matchDTO.getMemId());
		}else if(i!=1 && j==1) {
			matchMapper.memberMatchUpdate2(matchDTO.getPartnerId());
		}
			
		location="redirect:/admin/matching/match/matchList";
		return location;
	}
}
