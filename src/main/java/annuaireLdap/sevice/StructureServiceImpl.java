package annuaireLdap.sevice;

import annuaireLdap.dto.GroupDto;
import annuaireLdap.dto.UserDto;
import annuaireLdap.entities.Group;
import annuaireLdap.entities.Structure;
import annuaireLdap.repo.StructureRepo;
import annuaireLdap.dto.StructureDto;
import annuaireLdap.repo.UserRepo;
import annuaireLdap.util.ConvertUtilitiesGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import annuaireLdap.request.StructureRequest;
import annuaireLdap.util.ConvertUtilitiesStructure;
import org.springframework.stereotype.Service;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;
@Service
public class StructureServiceImpl implements StructureService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private LdapTemplate ldapTemplate;
    @Autowired
    StructureRepo structureRepo;
    @Override
    public StructureDto getStructureByOu(String req) {
         Structure s = structureRepo.getStructureByOu(req);
         StructureDto sd = ConvertUtilitiesStructure.convertStructureToStructureDto(s);
         return sd;
    }

    @Override
    public String addStructure(StructureRequest strReq) throws InvalidNameException{
        Structure newStr = ConvertUtilitiesStructure.convertStructureRequestToStructure(strReq);
        ldapTemplate.create(newStr);
//System.out.println(userRepo.findById(new LdapName("uid=012,ou=users")).get().getId());
        return newStr.getId().toString();
    }

    @Override
    public String updateStructure(StructureDto userDto) throws javax.naming.InvalidNameException {
// TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<StructureDto> getAllStructure() {
        List<Structure> strucList = structureRepo.findAll();
        List<StructureDto> groupsDtoList = ConvertUtilitiesStructure. convertListStructureToListStructureDto(strucList);
        return groupsDtoList;
    }

}
