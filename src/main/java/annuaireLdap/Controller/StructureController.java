package annuaireLdap.Controller;

import java.util.List;

import annuaireLdap.dto.GroupDto;
import annuaireLdap.dto.StructureDto;
import annuaireLdap.request.StructureRequest;
import annuaireLdap.sevice.StructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.InvalidNameException;
import javax.naming.NamingException;

@RestController
public class StructureController {
    @Autowired
    MessageSource messageSource;

    @Autowired
    StructureService strService;

    // @GetMapping(path = "/find-str-by-govcnrps")
// public  StructureDto findStructureByGovCnrps() throws Exception {
// StructureDto str=strService.getStructureByCnrps("001");
// return str;
//
// }
    @GetMapping(path = "/find-all-str")
    public List<StructureDto> findAllStructure() throws Exception {
        List<StructureDto> strList = strService.getAllStructure();
        return strList;

    }

    /* @PostMapping(path = "/add-structure")
     public String addStructure() throws InvalidNameException, NamingException {
         StructureRequest strReq = new StructureRequest();

         strReq.setId("ou=Tunisie,ou=structures");
         strReq.setOu("C50");
         //strReq.setDescriptionAr("ببيبيبيب");
         //strReq.setDescriptionFr("sdsdsd");
         //strReq.setStrPath("/Tunisie/C50");

         String newStructure = strService.addStructure(strReq);
         return newStructure;

 // newStructure.setMemberOf(listGroup);
 // newStructure= strRepo.save(newStructure);
 // Set<Name> listGroup = new HashSet<Name>();
 // listGroup.add(new LdapName("cn=testGroup2,ou=groups"));
 // listGroup.add(new LdapName("cn=testGroup3,ou=groups"));
 // newStructure.setMembersOf(listGroup);

     }

 // @PostMapping(path = "/update-str")
 // public String updateStructure() throws javax.naming.InvalidNameException {
 //
 // StructureDto strDto = strService.getStructureByCnrps("001");
 // System.out.println(strDto.getUid());
 // strDto.setCn("marwen");
 // strDto.setSn("rezgui");
 // strDto.setGivenName("rezgui marwen");
 // strDto.setMail("rezgui.marwene@gmail.com");
 // strDto.setStructurePassword("strPassword");
 // String updateStructure = strService.updateStructure(strDto);
 // return updateStructure;
 //
 // }*/
    @PostMapping(path = "/add-structure")
    public ResponseEntity<String> addStructure(@RequestBody StructureRequest structureRequest) throws InvalidNameException, NamingException {
        StructureRequest strReq = new StructureRequest();


        return new ResponseEntity<String>(strService.addStructure(structureRequest),HttpStatus.CREATED);
    }
    @GetMapping (path="/find-str-by-name/{name}")
    public StructureDto findStructureByOu(@PathVariable("name") String name) throws Exception{
        StructureDto structureDto =strService.getStructureByOu(name);
        return structureDto;
    }

}