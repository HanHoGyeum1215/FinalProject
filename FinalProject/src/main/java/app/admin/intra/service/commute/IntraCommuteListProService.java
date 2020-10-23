package app.admin.intra.service.commute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.intra.domain.IntraCommuteDTO;
import app.admin.intra.mapper.IntraCommuteMapper;

@Service
@Component
public class IntraCommuteListProService {

	@Autowired
	IntraCommuteMapper intraCommuteMapper;
	
public void intraCommuteListProService(String comDate,Model model)throws Exception {
		
	  List<IntraCommuteDTO> month = intraCommuteMapper.commuteLists(comDate);
	  System.out.println(comDate);
	  model.addAttribute("commuteList", month);
		
		
	}
	
}

	
	

