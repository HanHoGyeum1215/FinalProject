package app.admin.intra.service.answer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.intra.command.IntraAnswerCommand;
import app.admin.intra.domain.IntraAnswerDTO;
import app.admin.intra.mapper.IntraAskMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraAnswerWriteProService {
	
	@Autowired
	IntraAskMapper intraAskMapper;

	public void answerWritePro(IntraAnswerCommand intraAnswerCommand,HttpSession session)throws Exception{
	
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		IntraAnswerDTO dto = new IntraAnswerDTO();
		
		dto.setAnsCont(intraAnswerCommand.getAnsCont());
		dto.setSempId(authInfo.getId());
		dto.setAskNo(intraAnswerCommand.getAskNo());
		
		intraAskMapper.insertAnswer(dto);
		
	}
	
	
}
