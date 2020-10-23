package app.admin.intra.service.ask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;

@Service
@Component
public class IntraDeleteProService {
	
	@Autowired
	IntraAskMapper intraAskMapper;

	
	public void intraDeleteProService(Integer askNo)throws Exception{
		
		IntraAskDTO dto = new IntraAskDTO();
		
		dto.setAskNo(askNo);
		
		intraAskMapper.deleteAsk(dto);
	
	
	}
}
