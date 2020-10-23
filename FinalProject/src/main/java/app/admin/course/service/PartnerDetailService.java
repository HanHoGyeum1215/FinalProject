package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import app.admin.course.domain.PartnerDTO;
import app.admin.course.mapper.PartnerMapper;

@Component
@Service
public class PartnerDetailService {
	@Autowired
	PartnerMapper partnerMapper;
	
	public void partnerDetail(String venId, Model model) throws Exception{
		PartnerDTO partner = new PartnerDTO();
		partner.setVenId(venId);
		partner = partnerMapper.selectPartner(partner).get(0);
		model.addAttribute("partnerCommand", partner);		
	}

}
