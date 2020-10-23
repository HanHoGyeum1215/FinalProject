package app.admin.intra.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.command.IntraEmployeeCommand;
import app.admin.intra.domain.IntraEmployeeDTO;
import app.admin.intra.mapper.IntraEmployeeMapper;
import app.domain.StartEndPageDTO;

@Component
@Service
public class IntraEmployeeModifyService {
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;

	public Integer employeeModify(IntraEmployeeCommand intraEmployeeCommand) throws Exception {
		Integer result;
		
		StartEndPageDTO startEndPageDTO = new StartEndPageDTO(1L, 1L, intraEmployeeCommand.getEmpId(), null);
		IntraEmployeeDTO emp = intraEmployeeMapper.selectAllEmployee(startEndPageDTO).get(0);
		
		if (passwordEncoder.matches(intraEmployeeCommand.getEmpPass(), emp.getEmpPass())) {
			IntraEmployeeDTO dto = new IntraEmployeeDTO();
			dto.setEmpId(intraEmployeeCommand.getEmpId());
			dto.setDepNo(intraEmployeeCommand.getDepNo());
			dto.setEmpName(intraEmployeeCommand.getEmpName());
			dto.setEmpEmail(intraEmployeeCommand.getEmpEmail());
			dto.setEmpTel(intraEmployeeCommand.getEmpTel());
			dto.setEmpDuty(intraEmployeeCommand.getEmpDuty());
			result = intraEmployeeMapper.updateEmployee(dto);
		} else {
			result = 0;
		}
		
		return result;
	}
	
}
