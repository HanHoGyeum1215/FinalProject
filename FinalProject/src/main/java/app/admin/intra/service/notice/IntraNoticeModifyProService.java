package app.admin.intra.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;

@Component
@Service
public class IntraNoticeModifyProService {

	@Autowired
	IntraNoticeMapper intraNoticeMapper;
	
	public void IntraNoticeUpdate(IntraNoticeCommand intraNoticeCommand)throws Exception{
		
		IntraNoticeDTO dto = new IntraNoticeDTO();
		
		dto.setNotNo(intraNoticeCommand.getNotNo());
		dto.setNotCont(intraNoticeCommand.getNotCont());
		dto.setNotSub(intraNoticeCommand.getNotSub());
				
		intraNoticeMapper.updateNotice(dto);
	}
	
}
