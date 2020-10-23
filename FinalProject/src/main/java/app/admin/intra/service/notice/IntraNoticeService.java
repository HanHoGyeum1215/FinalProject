
package app.admin.intra.service.notice;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import app.admin.intra.command.IntraNoticeCommand;
import app.admin.intra.domain.IntraNoticeDTO;
import app.admin.intra.mapper.IntraNoticeMapper;
import app.command.AuthInfo;

@Service
@Component
public class IntraNoticeService {
	
	@Autowired
	IntraNoticeMapper intraNoticeMapper;
 
	public void execute(IntraNoticeCommand intraNoticeCommand, HttpSession session)throws Exception{
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		IntraNoticeDTO dto = new IntraNoticeDTO();
		
		dto.setEmpId(authInfo.getId());
		dto.setNotSub(intraNoticeCommand.getNotSub());
	    dto.setNotCont(intraNoticeCommand.getNotCont());
		/* dto.setFile(intraNoticeCommand.getFile()); */
				
		System.out.println(intraNoticeCommand.getNotCont());
		
		try {
			String PATH = "/notice/upload";
			String filePath = session.getServletContext().getRealPath(PATH);
			MultipartFile mf = intraNoticeCommand.getReport();
			String original = mf.getOriginalFilename();
			String originalFileExtension = original.substring(original.lastIndexOf("."));
			String store = UUID.randomUUID().toString().replace("-", "") + originalFileExtension;
			dto.setNotStoreFile(store);
			dto.setNotOriginFile(original);
			
			File file = new File(filePath + "/" + store);
			dto.setNotSize(mf.getSize());
			System.out.println(mf.getSize());
			mf.transferTo(file);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			intraNoticeMapper.insertNotice(dto);
		}
					
	}
	
	
	
}
		

