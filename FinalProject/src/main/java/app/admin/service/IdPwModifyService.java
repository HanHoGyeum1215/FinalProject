package app.admin.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraEmployeeDTO;
import app.admin.intra.mapper.IntraEmployeeMapper;
import app.admin.matching.domain.MemberDTO;
import app.admin.matching.mapper.MemberMapper;
import app.command.AuthInfo;
import app.command.ChangeIdCommand;
import app.command.ChangePwCommand;
import app.domain.StartEndPageDTO;
import app.domain.UserIdChangeDTO;
import app.domain.UserPwChangeDTO;

@Component
@Service
public class IdPwModifyService {
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;
	@Autowired
	MemberMapper memberMapper;
	@Autowired
	PasswordEncoder passwordEncoder;

	public String changePw(ChangePwCommand changePwCommand, HttpServletRequest request, Model model, String condition) throws Exception {
		String errorPath = "";
		String returnPath = "";
		String url = "";
		if (condition.equals("emp")) {			
			String [] urlArr = request.getRequestURI().substring(1).split("/");
			url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /admin/intra/ 가져오기
			errorPath = "thymeleaf/admin/common/forgot-password";
			returnPath = "thymeleaf/admin/common/completed";
		} else {
			errorPath = "thymeleaf/common/forgot-id-pw";
			returnPath = "thymeleaf/common/completed";
		}
		
		if ((changePwCommand.getNewPw().length() == 0) && (!changePwCommand.isNewPwToReNewPw())) {
			model.addAttribute("valid_reNewPw", "새로운 비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return errorPath;
		} else {
			StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, changePwCommand.getUserId(), null);
			
			if (condition.equals("emp")) {
				// 직원 비밀번호 변경
				IntraEmployeeDTO empDTO = null;
				List<IntraEmployeeDTO> list = intraEmployeeMapper.selectAllEmployee(startEndPageDTO);
			
				if (list.size() == 0) {
					model.addAttribute("valid_Id", "아이디가 존재하지 않습니다.");
					return errorPath;
				} else {
					empDTO = list.get(0);
					
					if (!empDTO.getEmpName().equals(changePwCommand.getUserName())) {
						model.addAttribute("valid_Name", "이름이 잘못 입력되었습니다.");
						return errorPath;
					} else if (!empDTO.getEmpEmail().equals(changePwCommand.getUserEmail())) {
						model.addAttribute("valid_Email", "이메일이 잘못 입력되었습니다.");
						return errorPath;
					}
					
					UserPwChangeDTO dto = new UserPwChangeDTO();
					dto.setUserId(changePwCommand.getUserId());
					dto.setUserName(changePwCommand.getUserName());
					dto.setUserEmail(changePwCommand.getUserEmail());
					dto.setNewPw(passwordEncoder.encode(changePwCommand.getNewPw()));
					intraEmployeeMapper.changePw(dto);
					
					model.addAttribute("url", url);
					model.addAttribute("completedText", "비밀번호가 변경되었습니다.");
					return returnPath;
				}
			} else {
				// 회원 비밀번호 변경
				List<MemberDTO> list = memberMapper.selectMember(startEndPageDTO);
				MemberDTO memDTO = null;
				if (list.size() == 0) {
					model.addAttribute("valid_Id", "아이디가 존재하지 않습니다.");
					return errorPath;
				} else {
					memDTO = list.get(0);
					
					if (!memDTO.getMemName().equals(changePwCommand.getUserName())) {
						model.addAttribute("valid_Name", "이름이 잘못 입력되었습니다.");
						return errorPath;
					} else if (!memDTO.getMemEmail().equals(changePwCommand.getUserEmail())) {
						model.addAttribute("valid_Email", "이메일이 잘못 입력되었습니다.");
						return errorPath;
					}
					
					UserPwChangeDTO dto = new UserPwChangeDTO();
					dto.setUserId(changePwCommand.getUserId());
					dto.setUserName(changePwCommand.getUserName());
					dto.setUserEmail(changePwCommand.getUserEmail());
					dto.setNewPw(passwordEncoder.encode(changePwCommand.getNewPw()));
					memberMapper.changePw(dto);
					
					model.addAttribute("completedText", "비밀번호가 변경되었습니다.");
					return returnPath;
				}
				
			}
		}
		
		
	}

	public String findId(ChangeIdCommand changeIdCommand, HttpServletRequest request, Model model, String condition) throws Exception {
		String returnPath = "";
		String url = "";
		String id = "";
		
		UserIdChangeDTO dto = new UserIdChangeDTO();
		dto.setUserName(changeIdCommand.getUserName());
		dto.setUserEmail(changeIdCommand.getUserEmail());
		dto.setUserTel(changeIdCommand.getUserTel());
		
		if (condition.equals("emp")) {
			String [] urlArr = request.getRequestURI().substring(1).split("/");
			url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /admin/intra/ 가져오기
			returnPath = "thymeleaf/admin/common/completed";
			id = intraEmployeeMapper.findId(dto);
		} else {
			returnPath = "thymeleaf/common/completed";
			id = memberMapper.findId(dto);
		}
		
		
		model.addAttribute("url", url);
		model.addAttribute("completedText", "아이디 찾기");
		if (id == null) {
			model.addAttribute("notId", "입력하신 정보와 일치하는 아이디를 찾을 수 없습니다.");
		} else {
			model.addAttribute("checkId", id + " 입니다.");
		}

		return returnPath;
	}
	
}
