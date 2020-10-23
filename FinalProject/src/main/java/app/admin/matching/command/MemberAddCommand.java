package app.admin.matching.command;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberAddCommand {
	String memCareer;
	String memJob;
	String memSalary;
	String memHgt;
	String memWgt;
	String memBlood;
	String memRlg;
	MultipartFile [] memImage;
	List memHobby;

}
