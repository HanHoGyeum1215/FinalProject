package app.admin.intra.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;

@Service
@Component
public class IntraNoticeDeleteProService {
	@Autowired
	IntraNoticeMapper intraNoticeMapper;

	public void NoticeDel(Integer notNo)throws Exception {
			
		IntraNoticeDTO dto = new IntraNoticeDTO();
		
		dto.setNotNo(notNo);
		/*dto.setEmpPass(empPass);*/
		
		intraNoticeMapper.deleteNotice(dto);
		
		
	}

		
	}

