package app.admin.course.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.course.domain.PartnerDTO;

@Component
@Repository(value = "app.admin.course.mapper.PartnerMapper")
public interface PartnerMapper {
	public Integer insertPartner(PartnerDTO partnerDTO) throws Exception;
	public List<PartnerDTO> selectPartner(PartnerDTO partnerDTO) throws Exception;
	public Integer partnerCount();	
	public Integer partnerDelete(String venId)throws Exception;
}
