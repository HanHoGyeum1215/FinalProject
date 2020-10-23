package app.admin.matching.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.matching.command.SurveyCommand;
import app.admin.matching.domain.SurveyDTO;
import app.admin.matching.mapper.SurveyMapper;
import app.command.AuthInfo;

@Service
@Component
public class SurveyWriteService {
	@Autowired
	SurveyMapper surveyMapper;
	public String execute(SurveyCommand surveyCommand, Model model, HttpSession session) throws Exception {
		/* String memId=((AuthInfo)session.getAttribute("authInfo")).getId(); */
		SurveyDTO surveyDTO=new SurveyDTO();
		/* surveyDTO.setMemId("aaa"); */
		
		String memId=((AuthInfo)session.getAttribute("authInfo")).getId();
		surveyDTO.setMemId(memId);
		surveyDTO.setSurAge(surveyCommand.getSurAge());
		System.out.println(surveyDTO.getSurAge());
		surveyDTO.setSurBlood(surveyCommand.getSurBlood());
		surveyDTO.setSurCareer(surveyCommand.getSurCareer());
		surveyDTO.setSurHgt(surveyCommand.getSurHgt());
		/*
		 * List list = new ArrayList(); list=surveyCommand.getSurHobby(); if
		 * (list!=null) { String [] surHobby= (String[]) list.toArray(new
		 * String[list.size()]); String hobbySum=""; for (String s : surHobby) {
		 * hobbySum+=s+"`"; } surveyDTO.setSurHobby(hobbySum); }else {
		 * surveyDTO.setSurHobby(""); }
		 */
		
		surveyDTO.setSurHobby(surveyCommand.getSurHobby());
		surveyDTO.setSurJob(surveyCommand.getSurJob());
		surveyDTO.setSurRlg(surveyCommand.getSurRlg());
		surveyDTO.setSurSalary(surveyCommand.getSurSalary());
		surveyDTO.setSurWgt(surveyCommand.getSurWgt());
		surveyMapper.insertSurvey(surveyDTO);
		return surveyDTO.getMemId();
		}
	}

