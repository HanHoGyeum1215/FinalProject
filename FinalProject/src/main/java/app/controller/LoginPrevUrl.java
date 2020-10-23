package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Component
@Service
public class LoginPrevUrl {

	public void execute(HttpServletRequest request, Model model, String defaultPath) {
		String path = defaultPath;
		if (request.getHeader("referer") != null) {
			int hostLength = request.getHeader("referer").indexOf(request.getHeader("host")) + request.getHeader("host").length();
			path = request.getHeader("referer").substring(hostLength);
		}
		
		model.addAttribute("path", path);
	}
	
}
