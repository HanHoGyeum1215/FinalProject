package app.admin.matching.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.matching.domain.EventJoinDTO;
import app.admin.matching.mapper.EventMapper;
@Service
@Component
public class EventJoinService {
	@Autowired
	EventMapper eventMapper;
	public void execute(String eveNo, String memId, HttpServletResponse response) throws Exception {
		EventJoinDTO eventJoinDTO=new EventJoinDTO();
		eventJoinDTO.setEveNo(eveNo);
		eventJoinDTO.setMemId(memId);
		try {
			eventMapper.eventJoin(eventJoinDTO);
			
		} catch (Exception e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('이미 참가신청을 하셨습니다.'); location.href='/matching/event/eventList';</script>");
			out.flush();
		}
		
	}	
	
	public void appUpdate(String eveNo) throws Exception {
		eventMapper.eventJoinApp(eveNo);
		
	}
}
