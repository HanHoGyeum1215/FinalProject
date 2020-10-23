package app.admin.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import app.admin.course.mapper.PartnerMapper;

@Component
@Service
public class PartnerDeleteService {
	@Autowired
	PartnerMapper partnerMapper;
	
	public void partnerDelete(String venId) throws Exception{
		partnerMapper.partnerDelete(venId);
	}

}
