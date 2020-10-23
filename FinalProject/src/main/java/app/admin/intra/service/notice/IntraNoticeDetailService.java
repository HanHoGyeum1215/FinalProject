package app.admin.intra.service.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;

@Service
@Component
public class IntraNoticeDetailService {

	@Autowired
	IntraNoticeMapper intraNoticeMapper;
	
	public void intraNoticeDetailService(Integer notNo,Model model )throws Exception {
		
		IntraNoticeDTO dto = intraNoticeMapper.detailNotice(notNo);
		intraNoticeMapper.readCount(notNo);
		
		model.addAttribute("intraNoticeCommand", dto);
	}
	
}
