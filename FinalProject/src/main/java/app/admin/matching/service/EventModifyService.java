package app.admin.matching.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.admin.matching.command.EventCommand;
import app.admin.matching.domain.EventDTO;
import app.admin.matching.domain.FileName;
import app.admin.matching.mapper.EventMapper;
import app.command.AuthInfo;
import app.domain.StartEndPageDTO;

@Service
@Component
public class EventModifyService {
	@Autowired
	EventMapper eventMapper;

	public Integer execute(String eveNo, HttpSession session, EventCommand eventCommand) throws Exception {
		String venId = ((AuthInfo) session.getAttribute("authInfo")).getId();
		EventDTO eventDTO = new EventDTO();
		eventDTO.setEveSubject(eventCommand.getEveSubject().replace("\r\n", "<br>"));
		eventDTO.setEveContent(eventCommand.getEveContent());
		/*
		 * Timestamp eveDate=Timestamp.valueOf(eventCommand.getEveDate());
		 * System.out.println(eveDate);
		 */
		eventDTO.setEveDate(eventCommand.getEveDate());
		eventDTO.setEveLoc(eventCommand.getEveLoc());
		eventDTO.setEveMxCnt(eventCommand.getEveMxCnt());
		eventDTO.setEveNo(eventCommand.getEveNo());
		eventDTO.setVenId(venId);
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, eventDTO.getVenId(),
				eventDTO.getEveNo().toString());
		EventDTO event = eventMapper.selectEvent(startEndPageDTO).get(0);
		List<FileName> list = (List<FileName>) session.getAttribute("fileList");
		System.out.println(list);
		if (list != null) {
			for (FileName fi : list) {
				event.setEveOriginalImage(event.getEveOriginalImage().replace(fi.getEveOriginalImage() + "`", ""));
				event.setEveStoreImage(event.getEveStoreImage().replace(fi.getEveStoreImage() + "`", ""));

			}
		}
		File file = null;
		String originalTotal = "";
		String storeTotal = "";
		String path1 = "/static/upload/event";
		String filePath = session.getServletContext().getRealPath(path1);

		for (MultipartFile mf : eventCommand.getEveImage()) {
			if (mf.getSize() > 0) {

				String original = mf.getOriginalFilename();
				String originalFileExtension = original.substring(original.lastIndexOf("."));
				String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
				originalTotal += original + "`";
				storeTotal += store + "`";

				file = new File(filePath + "/" + store);
				try {
					mf.transferTo(file);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		if (event.getEveOriginalImage() == null) {
			eventDTO.setEveOriginalImage(originalTotal);
			eventDTO.setEveStoreImage(storeTotal);
		} else {
			eventDTO.setEveOriginalImage(originalTotal + event.getEveOriginalImage());
			eventDTO.setEveStoreImage(storeTotal + event.getEveStoreImage());
		}
		Integer i=eventMapper.eventUpdate(eventDTO);

		if (list != null) {
			for (FileName fi : list) {
				file = new File(filePath + "/" + fi.getEveStoreImage().replace("`", ""));
				if (file.exists())
					file.delete();
			}
			// session 삭제
			session.removeAttribute("fileList");
		}

		return i;
	}
}
