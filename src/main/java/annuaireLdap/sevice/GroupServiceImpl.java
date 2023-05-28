package annuaireLdap.sevice;

import java.util.List;

import javax.naming.InvalidNameException;

import annuaireLdap.entities.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;

import annuaireLdap.repo.GroupRepo;
import annuaireLdap.dto.GroupDto;
import org.springframework.stereotype.Service;
import annuaireLdap.request.GroupRequest;
import annuaireLdap.util.ConvertUtilitiesGroup;
@Service
public class GroupServiceImpl implements GroupService{
  @Autowired
  GroupRepo groupRepo;
  @Autowired
  private LdapTemplate ldapTemplate;
  
  
  
  @Override
  public List<GroupDto> getAllGroup(){
	  List<Group> groupsList = groupRepo.findAll();
	  List<GroupDto> groupsDtoList = ConvertUtilitiesGroup.convertListGroupToListGroupDto(groupsList);
	  return groupsDtoList;
  }
  @Override
  public GroupDto getGroupByCn(String req) {
	  Group g = groupRepo.findByCn(req);
	  GroupDto groupDto = ConvertUtilitiesGroup.ConvertGroupToGroupDto(g);
	  return groupDto;
  }
@Override
public String addGroup(GroupRequest groupReq) throws InvalidNameException {

	Group newGroup = ConvertUtilitiesGroup.convertGroupRequestToGroup(groupReq);
    ldapTemplate.create((newGroup));
    return newGroup.getId().toString();
}
@Override
public String updateGroupWithoutDeleteMembers(GroupDto dto) throws InvalidNameException {
	// TODO Auto-generated method stub
	return null;
}
@Override
public String updateGroupWithDeleteMembers(GroupDto dto) throws InvalidNameException {
	// TODO Auto-generated method stub
	return null;
}
  

  
  
  
  
  
  
}
