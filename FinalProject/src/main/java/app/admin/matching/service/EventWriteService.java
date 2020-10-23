package app.admin.matching.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import app.admin.matching.command.EventCommand;
import app.admin.matching.domain.EventDTO;
import app.admin.matching.mapper.EventMapper;
import app.command.AuthInfo;

@Service
@Component
@Transactional
public class EventWriteService {
	@Autowired
	EventMapper eventMapper;
	
	public String insertEvent(EventCommand eventCommand, Model model, HttpServletRequest request) {
		String location="";
		HttpSession session=request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		EventDTO eventDTO=new EventDTO();
		eventDTO.setEveContent(eventCommand.getEveContent().replace("\r\n", "<br>"));
//		Timestamp eveDate=Timestamp.valueOf(eventCommand.getEveDate());
		eventDTO.setEveDate(eventCommand.getEveDate());
		eventDTO.setEveLoc(eventCommand.getEveLoc());
		eventDTO.setEveMxCnt(eventCommand.getEveMxCnt());
		eventDTO.setEveSubject(eventCommand.getEveSubject());
		eventDTO.setVenId(authInfo.getId());
		String originalTotal = "";
		String storeTotal = "";
		String PATH = "/static/upload/event";
		String filePath=request.getServletContext().getRealPath(PATH);
		for (MultipartFile mf : eventCommand.getEveImage()) {
			String original=mf.getOriginalFilename();
			String originalFileExtension=original.substring(original.lastIndexOf("."));
			String store=UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
			originalTotal+=original+"`";
			storeTotal+=store+"`";
					
			File file=new File(filePath+"/"+store);
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				// TODO: handle exception
				location="thymeleaf/admin/matching/event/event_write";
				e.printStackTrace();
			}
			
		}
		eventDTO.setEveOriginalImage(originalTotal);
		eventDTO.setEveStoreImage(storeTotal);
		eventMapper.eventInsert(eventDTO);
		location="redirect:/admin/matching/event/eventList";
		return location;
	}
}
