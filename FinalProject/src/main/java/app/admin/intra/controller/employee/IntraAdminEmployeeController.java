package app.admin.intra.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.admin.intra.command.IntraEmployeeCommand;
import app.admin.intra.mapper.IntraEmployeeMapper;
import app.admin.intra.service.employee.IntraEmployeeDetailService;
import app.admin.intra.service.employee.IntraEmployeeListService;
import app.admin.intra.service.employee.IntraEmployeeModifyService;
import app.admin.intra.service.employee.IntraEmployeeWriteService;

@Controller
@RequestMapping("/admin/intra/employee")
public class IntraAdminEmployeeController {
	@Autowired
	IntraEmployeeMapper intraEmployeeMapper; 
	@Autowired
	IntraEmployeeWriteService intraEmployeeWriteService;
	@Autowired
	IntraEmployeeListService intraEmployeeListService;
	@Autowired
	IntraEmployeeDetailService intraEmployeeDetailService;
	@Autowired
	IntraEmployeeModifyService intraEmployeeModifyService;
	
	@ModelAttribute
	IntraEmployeeCommand setIntraEmployeeCommand() {
		return new IntraEmployeeCommand(); 
	}
	
	@RequestMapping("employeeList")
	public String employeeList(
			@RequestParam(value = "page", defaultValue = "1") Integer page,
				Model model
			) throws Exception {
		intraEmployeeListService.employeeList(model, page);
		return "thymeleaf/admin/intra/employee/employee_list";
	}
	@RequestMapping("employeeView/{id}")
	public String employeeView(
				@PathVariable(value = "id") String empId,
				Model model
			) throws Exception {
		intraEmployeeDetailService.employeeDetail(model, empId);
		return "thymeleaf/admin/intra/employee/employee_view";
	}
	@RequestMapping("employeeWrite")
	public String employeeWrite(
				Model model
			) throws Exception {
		model.addAttribute("depList", intraEmployeeMapper.selectAllDepartment());
		return "thymeleaf/admin/intra/employee/employee_write";
	}
	@RequestMapping("employeeWritePro")
	public String employeeWritePro(
				@Validated IntraEmployeeCommand intraEmployeeCommand,
				BindingResult result,
				Model model
			) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("depList", intraEmployeeMapper.selectAllDepartment());
			return "thymeleaf/admin/intra/employee/employee_write";
		}
		
		intraEmployeeWriteService.insertEmployee(intraEmployeeCommand, model);
		return "redirect:/admin/intra/";
	}
	@RequestMapping("employeeModify/{id}")
	public String employeeModify(
				@PathVariable(value = "id") String empId,
				@RequestParam(value = "depChk") Long depChk,
				Model model,
				IntraEmployeeCommand intraEmployeeCommand
			) throws Exception {
		intraEmployeeDetailService.employeeDetail(model, empId);
		model.addAttribute("depList", intraEmployeeMapper.selectAllDepartment());
		model.addAttribute("depChk", depChk);
		return "thymeleaf/admin/intra/employee/employee_modify";
	}
	
	@RequestMapping("employeeModifyPro")
	public String employeeModifyPro(
			@Validated IntraEmployeeCommand intraEmployeeCommand,
			@RequestParam(value = "depChk") Long depChk,
			BindingResult result,
			Model model
			) throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("depList", intraEmployeeMapper.selectAllDepartment());
			return "thymeleaf/admin/intra/employee/employee_modify";
		}
		Integer i = intraEmployeeModifyService.employeeModify(intraEmployeeCommand);
		if (i > 0) {
			return "redirect:/admin/intra/employee/employeeView/" + intraEmployeeCommand.getEmpId();
		} else {
			model.addAttribute("valid_Pw", "비밀번호가 틀렸습니다");
			model.addAttribute("depList", intraEmployeeMapper.selectAllDepartment());
			model.addAttribute("depChk", depChk);
			return "thymeleaf/admin/intra/employee/employee_modify";
		}
	}
	
	/*
	@RequestMapping("employeeDelete")
	public String employeeDelete() {
		return "thymeleaf/admin/intra/employee/employee_delete";
	}
	*/
}
