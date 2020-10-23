package app.admin.intra.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.command.IntraEmployeeCommand;
import app.admin.intra.domain.IntraEmployeeDTO;
import app.admin.intra.mapper.IntraEmployeeMapper;

@Component
@Service
public class IntraEmployeeWriteService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;
	
	public void insertEmployee(IntraEmployeeCommand intraEmployeeCommand, Model model) throws Exception {
		IntraEmployeeDTO dto = new IntraEmployeeDTO();
		dto.setEmpId(intraEmployeeCommand.getEmpId());
		dto.setDepNo(intraEmployeeCommand.getDepNo());
		dto.setEmpPass(passwordEncoder.encode(intraEmployeeCommand.getEmpPass()));
		dto.setEmpName(intraEmployeeCommand.getEmpName());
		dto.setEmpEmail(intraEmployeeCommand.getEmpEmail());
		dto.setEmpTel(intraEmployeeCommand.getEmpTel());
		// dto.setEmpDuty();
		
		intraEmployeeMapper.insertEmployee(dto);
	}
	
}
