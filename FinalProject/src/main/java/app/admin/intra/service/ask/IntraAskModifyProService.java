package app.admin.intra.service.ask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraAskCommand;
import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;


@Service
@Component
public class IntraAskModifyProService {

	@Autowired
	IntraAskMapper intraAskMapper;
	
	public void intraAskModifyProService(IntraAskCommand intraAskCommand)throws Exception{
				
		IntraAskDTO dto = new IntraAskDTO();
		
		dto.setAskNo(intraAskCommand.getAskNo());
		dto.setAskCont(intraAskCommand.getAskCont());
		dto.setAskSub(intraAskCommand.getAskSub());
		
		intraAskMapper.updateAsk(dto);
		
		
		
		
		
	}
	
}
