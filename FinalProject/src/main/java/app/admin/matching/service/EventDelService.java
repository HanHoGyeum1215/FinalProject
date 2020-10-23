package app.admin.matching.service;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.matching.domain.EventDTO;
import app.admin.matching.mapper.EventMapper;
import app.command.AuthInfo;
import app.domain.StartEndPageDTO;

@Service
@Component
public class EventDelService {
	@Autowired
	EventMapper eventMapper;
	public Integer execute(String eveNo, HttpSession session) throws Exception {
		String venId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L,1L,null,eveNo);
		
		EventDTO eventDTO=eventMapper.selectEvent(startEndPageDTO).get(0);
		eventDTO.setVenId(venId);
		Integer i=eventMapper.eventDel(eventDTO);
		if (i==1) {
			String [] files=eventDTO.getEveStoreImage().split("`");
			String path="/static/upload/event";
			String filePath=session.getServletContext().getRealPath(path);
			File file=null;
			for (String fileName : files) {
				file=new File(filePath+"/"+fileName);
				if (file.exists()) {
					file.delete();
					
				}
			}
		}
		
		return i;
	}
}
