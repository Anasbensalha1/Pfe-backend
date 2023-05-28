package annuaireLdap.request;

import lombok.Data;

import java.util.Set;

@Data
public class StructureRequest {
    private String id;
    private String ou;
    private String structureName;
    private String structureType;
    private String website;
    private String socialNetwork;
    private String contact;
    private Set<String> employeeList;

}
