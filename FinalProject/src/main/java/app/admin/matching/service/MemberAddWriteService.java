package app.admin.matching.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import app.admin.matching.command.MemberAddCommand;
import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.mapper.MemberMapper;
import app.command.AuthInfo;

@Service
@Component
@Transactional
public class MemberAddWriteService {
	@Autowired
	MemberMapper memberMapper;

	public Integer insertMemberAdd(MemberAddCommand memberAddCommand, HttpServletRequest request)   {
		Integer result = null;
		MemberAddDTO memberAddDTO = new MemberAddDTO();
		/* memberAddDTO.setMemId("aaa"); */
		HttpSession session = request.getSession();
		String memId=((AuthInfo)session.getAttribute("authInfo")).getId();
		memberAddDTO.setMemId(memId);
		System.out.println(memberAddDTO.getMemId());
		memberAddDTO.setMemBlood(memberAddCommand.getMemBlood());
		System.out.println(memberAddDTO.getMemBlood());
		memberAddDTO.setMemCareer(memberAddCommand.getMemCareer());
		System.out.println(memberAddDTO.getMemCareer());
		memberAddDTO.setMemHgt(memberAddCommand.getMemHgt());
		System.out.println(memberAddDTO.getMemHgt());
		/* memberAddDTO.setMemHobby(memberAddCommand.getMemHobby()); */

		String hobbySum = "";
		if (memberAddCommand.getMemHobby() != null) {
			List list = new ArrayList();
			list = memberAddCommand.getMemHobby();
			String[] memHobby = (String[]) list.toArray(new String[list.size()]);
			for (String s : memHobby) {
				hobbySum += s + " ";
			}
		}
		

		System.out.println(hobbySum);
		memberAddDTO.setMemHobby(hobbySum);
		memberAddDTO.setMemJob(memberAddCommand.getMemJob());
		System.out.println(memberAddDTO.getMemJob());
		memberAddDTO.setMemRlg(memberAddCommand.getMemRlg());
		System.out.println(memberAddDTO.getMemRlg());
		memberAddDTO.setMemSalary(memberAddCommand.getMemSalary());
		System.out.println(memberAddDTO.getMemSalary());
		memberAddDTO.setMemWgt(memberAddCommand.getMemWgt());
		System.out.println(memberAddDTO.getMemWgt());
		
		String location="";
		String originalTotal = "";
		String storeTotal = "";
		String PATH="/static/upload/member";
		String filePath=request.getServletContext().getRealPath(PATH);
		System.out.println(filePath);
		
		
		for (MultipartFile mf : memberAddCommand.getMemImage()) {
			String original=mf.getOriginalFilename();
			String originalFileExtension=original.substring(original.lastIndexOf("."));
			String store=UUID.randomUUID().toString().replace("-", "")+originalFileExtension;
			originalTotal+=original+" ";
			storeTotal+=store+" ";
			File file=new File(filePath+"/"+store);
			
			
			try {
				mf.transferTo(file);
			} catch (Exception e) {
				location="thymeleaf/matching/mypage/member_add_write";
				e.printStackTrace();
			}
			
		}
		
		memberAddDTO.setMemOriginalImage(originalTotal);
		System.out.println(memberAddDTO.getMemOriginalImage());
		memberAddDTO.setMemStoreImage(storeTotal);
		System.out.println(memberAddDTO.getMemStoreImage());
		
		try {
			result = memberMapper.insertMemberAdd(memberAddDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
