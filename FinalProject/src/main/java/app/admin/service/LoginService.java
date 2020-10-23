package app.admin.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraEmployeeDTO;
import app.admin.intra.mapper.IntraEmployeeMapper;
import app.command.AuthInfo;
import app.command.LoginCommand;
import app.domain.StartEndPageDTO;

@Component
@Service
public class LoginService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;
	
	AuthInfo authInfo;
	
	public String execute(LoginCommand loginCommand, HttpServletRequest request, Model model,
			HttpServletResponse response) throws Exception {
		String [] urlArr = request.getRequestURI().substring(1).split("/");
		String url = "/" + urlArr[0] + "/" + urlArr[1] + "/"; // /admin/intra/ 가져오기
		HttpSession session = request.getSession();
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, loginCommand.getUserId(), null);
		List<IntraEmployeeDTO> list = intraEmployeeMapper.selectAllEmployee(startEndPageDTO);
		
		if (list.size() == 0) {
			System.out.println("아이디가 없습니다!");
			model.addAttribute("valid_Id", "아이디가 존재하지 않습니다.");
			return "thymeleaf/admin/common/login";
		} else {
			IntraEmployeeDTO empDTO = list.get(0);
			if (passwordEncoder.matches(loginCommand.getUserPw(), empDTO.getEmpPass())) {
				System.out.println("로그인 성공!");
				authInfo = new AuthInfo(
							empDTO.getEmpId(), 
							empDTO.getEmpEmail(), 
							empDTO.getEmpName(), 
							empDTO.getEmpPass(),
							"admin"
						);
				session.setAttribute("authInfo", authInfo);
				
				Boolean idStore = loginCommand.getIdStore();
				Boolean autologin = loginCommand.getAutoLogin();
				
				if (autologin != null && autologin == true) {
					Cookie cookie = new Cookie("autoLogin", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				}
				if (idStore != null && idStore == true) {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(60*60*24*30);
					response.addCookie(cookie);
				} else {
					Cookie cookie = new Cookie("idStore", authInfo.getId());
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
				
				return "redirect:" + loginCommand.getPath();
			} else {
				System.out.println("비밀번호가 틀렸습니다!");
				model.addAttribute("valid_Pw", "비밀번호가 틀렸습니다.");
				return "thymeleaf/admin/common/login";
			}
			
		}
	}
	
	
}
