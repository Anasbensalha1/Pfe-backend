package annuaireLdap.Controller;

import annuaireLdap.dto.GroupDto;
import annuaireLdap.dto.UserDto;
import annuaireLdap.request.GroupRequest;
import annuaireLdap.request.UserRequest;
import annuaireLdap.sevice.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@RestController
public class GroupController {
    @Autowired
    MessageSource messageSource;
    @Autowired
    GroupService groupService;

    @GetMapping(path="/find-all-group")
    public List<GroupDto> findAllUser () throws Exception{
        List<GroupDto> groupList =groupService.getAllGroup();
        return groupList;
    }
    @GetMapping (path="/find-group-by-cn/{cn}")
    public GroupDto findGroupByCn(@PathVariable("cn") String cn) throws Exception{
        GroupDto groupDto =groupService.getGroupByCn(cn);
        return groupDto;
    }

   /* @PostMapping(path = "/add-group")
    public String addGroup() throws Exception{
        GroupRequest groupRequest = new GroupRequest();
        groupRequest.setId("cn=faouziGroup, ou=Groups");
        groupRequest.setDescription("description");
        Set<String> members = new HashSet<String>();
        members.add("uid=003,ou=users,dc=cni,dc=tn");
        groupRequest.setMembers(members);
        return groupService.addGroup(groupRequest);
    }*/
   @PostMapping(path = "/add-group")
   public ResponseEntity<String> adduser(@RequestBody GroupRequest groupRequest) throws InvalidNameException, NamingException {
       return new ResponseEntity<String>(groupService.addGroup(groupRequest), HttpStatus.CREATED);
   }

}
