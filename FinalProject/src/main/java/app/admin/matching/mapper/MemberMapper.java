package app.admin.matching.mapper;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import app.admin.matching.domain.MemberAddDTO;
import app.admin.matching.domain.MemberDTO;
import app.domain.MemberJoinOkDTO;
import app.domain.StartEndPageDTO;
import app.domain.UserIdChangeDTO;
import app.domain.UserPwChangeDTO;

@Component
@Repository
public interface MemberMapper {
	public Integer insertMember(MemberDTO dto) throws Exception;
	public Integer insertMemberAdd(MemberAddDTO dto) throws Exception;
	public List<MemberDTO> selectMember(StartEndPageDTO startEndPageDTO) throws Exception;
	public List<MemberDTO> selectPaidMember(StartEndPageDTO startEndPageDTO) throws Exception;
	public Integer getMemberCount(String value) throws Exception;
	public Integer updateJoinOk(MemberJoinOkDTO dto) throws Exception;
	public String findId(UserIdChangeDTO dto) throws Exception;
	public void changePw(UserPwChangeDTO dto) throws Exception;
	public Integer updateMember(MemberDTO dto) throws Exception;
	public List<MemberAddDTO> selectAddInfo(String memId) throws Exception;
	public void updateMemberAdd(String memId) throws Exception;
	public String selectExpireDate(String memId) throws Exception;
}
