package annuaireLdap.sevice;


import annuaireLdap.dto.GroupDto;
import annuaireLdap.dto.StructureDto;
import annuaireLdap.dto.UserDto;
import annuaireLdap.request.StructureRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface StructureService {
   // public StructureDto getStructureByStructureName(String req);
    public String addStructure(StructureRequest StructureReq) throws InvalidNameException;
    public String updateStructure(StructureDto dto) throws InvalidNameException;
    public List<StructureDto> getAllStructure();
    //public String updateStructureWithDeleteEmployees(StructureDto dto) throws InvalidNameException;
    public StructureDto getStructureByOu(String req);
}
