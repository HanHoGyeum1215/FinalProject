package app.admin.intra.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.intra.domain.IntraCommuteDTO;

@Component
@Repository(value = "app.admin.intra.mapper.IntraCommuteMapper")
public interface IntraCommuteMapper {
	
	public int insertCommute(IntraCommuteDTO dto) throws Exception;
	public int insertWorkOut(IntraCommuteDTO dto) throws Exception;
	public List<IntraCommuteDTO> commuteList()throws Exception;
	public List<IntraCommuteDTO> commuteLists(String comDate);
	public Integer commuteCount() throws Exception;
	
	


	

}
