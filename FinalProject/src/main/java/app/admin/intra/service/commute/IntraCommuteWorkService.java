package app.admin.intra.service.commute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraCommuteCommand;
import app.admin.intra.domain.IntraCommuteDTO;
import app.admin.intra.mapper.IntraCommuteMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraCommuteWorkService {

	@Autowired
	IntraCommuteMapper intraCommuteMapper;
	
	
	
	public void goWork(IntraCommuteCommand intraCommuteCommand,HttpSession session,
			HttpServletRequest request)throws Exception{
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		IntraCommuteDTO dto = new IntraCommuteDTO();
		
		dto.setEmpId(authInfo.getId());
		dto.setComDate(intraCommuteCommand.getComDate());
		dto.setComGo(intraCommuteCommand.getComGo());
		dto.setComLeave(intraCommuteCommand.getComLeave());
		dto.setComNo(intraCommuteCommand.getComNo());
		dto.setComIp(request.getRemoteAddr());

		intraCommuteMapper.insertCommute(dto);
	
		
	}
	public void outWork(IntraCommuteCommand intraCommuteCommand, HttpSession session)throws Exception{
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		
		IntraCommuteDTO dto = new IntraCommuteDTO();
		
		dto.setEmpId(authInfo.getId());
		dto.setComDate(intraCommuteCommand.getComDate());
		dto.setComGo(intraCommuteCommand.getComGo());
		dto.setComLeave(intraCommuteCommand.getComLeave());
		dto.setComNo(intraCommuteCommand.getComNo());
		
		intraCommuteMapper.insertWorkOut(dto);
	}
	
		
		
	}

