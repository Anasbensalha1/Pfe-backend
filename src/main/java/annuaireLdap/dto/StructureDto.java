package annuaireLdap.dto;

import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;

import java.util.Set;

@Data
public class StructureDto {
    private String id;
    private String ou;
    private String structureType;
    private String strucuretPath;
    private String descriptionFr;
    private String descriptionAr;



}
