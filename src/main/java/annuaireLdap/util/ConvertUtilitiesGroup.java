package annuaireLdap.util;



import annuaireLdap.entities.Group;
import annuaireLdap.dto.GroupDto;
import annuaireLdap.request.GroupRequest;
import javax.lang.model.element.Name;
import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class ConvertUtilitiesGroup {
	 public static GroupDto ConvertGroupToGroupDto(Group g) {
		 GroupDto groupDto = new GroupDto();
		 groupDto.setId(g.getId().toString());
		 groupDto.setCn(g.getCn());
		 groupDto.setDescription(g.getDescription());
		 HashSet<String> setMembers = new HashSet<String>();
		 for(javax.naming.Name dn:g.getMembers()) {
			setMembers.add(dn.toString());
			
		 }
		 groupDto.setMembers(setMembers);
		 return groupDto;
     }
	 public static List<GroupDto> convertListGroupToListGroupDto(List<Group> listGroup){
		 List<GroupDto> listGroupDto = new ArrayList<GroupDto>();
		 for(Group u:listGroup) {
			 listGroupDto.add(ConvertGroupToGroupDto(u));
		 }
		 return listGroupDto;
		 
	 }
	 public static Group convertGroupRequestToGroup(GroupRequest req) throws InvalidNameException {
		 Group group = new Group();
		 group.setId(new LdapName(req.getId()));
		 group.setCn(req.getCn());
		 group.setDescription(req.getDescription());
		 for(String m:req.getMembers()) {
			 System.out.println("m::"+m);
			 group.addMember(new LdapName(m));


		 }
		return group;
	 }
	 public static String convertNameToString(Name id) throws InvalidNameException {
		 return id.toString();
	 }
	 public static Set<String>  convertSetNameToSetString(Set<Name> setId) throws InvalidNameException{
		 HashSet<String> setIds = new HashSet<String>();
		 for(Name n:setId){
			 setIds.add(convertNameToString(n));
		 }
		 return setIds;
	 }

	
}

	 
