package app.admin.intra.service.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraEmployeeDTO;
import app.admin.intra.mapper.IntraEmployeeMapper;
import app.controller.PageAction;
import app.domain.StartEndPageDTO;

@Component
@Service
public class IntraEmployeeListService {
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper;

	public void employeeList(Model model, Integer page) throws Exception {
		int limit = 10;
		int limitPage = 10;
		
		Long startRow = ((long) page - 1) * limit + 1;
		Long endRow = startRow + limit - 1;
		
		StartEndPageDTO dto = new StartEndPageDTO(startRow, endRow, null, null);
		List<IntraEmployeeDTO> list = intraEmployeeMapper.selectAllEmployee(dto);
		int count = intraEmployeeMapper.selectCountEmployee();
		
		model.addAttribute("employeeList", list);
		model.addAttribute("count", count);
		
		PageAction pageAction = new PageAction();
		pageAction.page(model, count, limit, limitPage, page, "employeeList");
		
	}
	
	
}
