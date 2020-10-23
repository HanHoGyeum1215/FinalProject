package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MemberDTO;
import app.admin.matching.domain.SurveyDTO;

@Component
@Repository
public interface SurveyMapper {
	public SurveyDTO selectSurvey(String memId) throws Exception;
	public List<MemberDTO> selectMember(SurveyDTO dto) throws Exception;
	public void insertSurvey(SurveyDTO dto) throws Exception;

}
