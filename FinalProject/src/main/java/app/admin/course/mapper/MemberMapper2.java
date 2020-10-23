package app.admin.course.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.course.domain.MemberDTO2;

@Component
@Repository
public interface MemberMapper2 {
	public Integer insertMember(MemberDTO2 memberDTO) throws Exception;
	public List<MemberDTO2> selectMember(MemberDTO2 memberDTO) throws Exception;
	public Integer memberCount();	
	public Integer memberDelete(String memId)throws Exception;
}
