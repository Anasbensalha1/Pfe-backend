package annuaireLdap.sevice;

import java.util.List;

import annuaireLdap.dto.GroupDto;
import annuaireLdap.request.GroupRequest;

import javax.naming.InvalidNameException;

public interface GroupService {
	public GroupDto getGroupByCn(String req);
	public String addGroup(GroupRequest groupReq) throws InvalidNameException;
	public String updateGroupWithoutDeleteMembers(GroupDto dto) throws InvalidNameException;
	public List<GroupDto> getAllGroup();
	public String updateGroupWithDeleteMembers(GroupDto dto) throws InvalidNameException;
}
