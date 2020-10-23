package app.admin.intra.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IntraEmployeeDTO {
	String empId;
	Long depNo;
	String empPass;
	String empName;
	String empEmail;
	String empTel;
	String empDuty;
	Timestamp createAt;
	
	IntraDepartmentDTO department;
	
}
