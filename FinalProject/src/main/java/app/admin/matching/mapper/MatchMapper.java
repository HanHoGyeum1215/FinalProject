package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MatchDTO;
import app.admin.matching.domain.MatchPayDTO;
import app.domain.StartEndPageDTO;

@Component
@Repository
public interface MatchMapper {
	public Integer matchInsert(MatchDTO dto) throws Exception;
	public List<MatchDTO> selectMatch(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getMatchCount();
	public void matchUpdate(MatchDTO dto) throws Exception;
	public void matchPayInsert(MatchPayDTO dto) throws Exception;
	public Integer memberMatchUpdate(String id) throws Exception;
	public Integer memberMatchUpdate2(String id) throws Exception;
	
}
