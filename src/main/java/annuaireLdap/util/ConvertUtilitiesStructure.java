package annuaireLdap.util;

import annuaireLdap.entities.Structure;
import annuaireLdap.dto.StructureDto;
import annuaireLdap.request.StructureRequest;

import javax.lang.model.element.Name;
import javax.naming.InvalidNameException;
import javax.naming.ldap.LdapName;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvertUtilitiesStructure {
    public static StructureDto convertStructureToStructureDto(Structure u) {
        StructureDto strDto = new StructureDto();
        strDto.setId(u.getId().toString());
        strDto.setOu(u.getOu());
        return strDto;
    }

    public static List<StructureDto> convertListStructureToListStructureDto(List<Structure> listStructure) {
        List<StructureDto> listStructureDto= new ArrayList<StructureDto>();
        for(Structure u:listStructure) {
            listStructureDto.add(convertStructureToStructureDto(u));
        }

        return listStructureDto;
    }

    public static Structure convertStructureRequestToStructure(StructureRequest req) throws InvalidNameException {
        Structure str = new Structure();
        str.setId(new LdapName(req.getId()));
        str.setOu(req.getOu());
       // str.setDescriptionAr(req.getDescriptionAr());
        //str.setDescriptionFr(req.getDescriptionFr());
       // str.setStrucuretPath(req.getStrPath());
        return str;
    }

    public static Structure convertStructureDtoToStructure(StructureDto dto) throws InvalidNameException {
        Structure str = new Structure();


        return str;
    }}