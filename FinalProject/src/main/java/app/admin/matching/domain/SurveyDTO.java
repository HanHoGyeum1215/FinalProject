package app.admin.matching.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDTO {
	String surNo;
	String memId;
	String surAge;
	String surCareer;
	String surJob;
	String surSalary;
	String surBlood;
	String surHgt;
	String surWgt;
	String surHobby;
	String surRlg;
	String memGender;
}
