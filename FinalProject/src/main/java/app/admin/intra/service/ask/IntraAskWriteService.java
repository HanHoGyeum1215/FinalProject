package app.admin.intra.service.ask;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.admin.intra.command.IntraAskCommand;
import app.admin.intra.domain.IntraAskDTO;
import app.admin.intra.mapper.IntraAskMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraAskWriteService {

	@Autowired
	IntraAskMapper intraAskMapper;
	
	public void askWrite(IntraAskCommand intraAskCommand, HttpSession session)throws Exception{
		
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		
		IntraAskDTO dto = new IntraAskDTO();
		
		dto.setEmpId(authInfo.getId());
		dto.setAskSub(intraAskCommand.getAskSub());
	    dto.setAskCont(intraAskCommand.getAskCont());
		
	    
		try {
			String PATH = "/ask/upload";
			String filePath = session.getServletContext().getRealPath(PATH);
			MultipartFile mf = intraAskCommand.getReport();
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			dto.setAskStoreFile(store);
			dto.setAskOriginFile(original);
			
			File file = new File(filePath + "/" + store);
			dto.setAskSize(mf.getSize());
			System.out.println(mf.getSize());
			mf.transferTo(file);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			intraAskMapper.insertAsk(dto);
		}
	    
	    
	
		
	}
	
	
	
}
