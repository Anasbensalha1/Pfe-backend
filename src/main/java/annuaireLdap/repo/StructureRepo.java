package annuaireLdap.repo;

import annuaireLdap.entities.Structure;
import org.springframework.data.ldap.repository.LdapRepository;

public interface StructureRepo extends LdapRepository<Structure> {
    public Structure getStructureByOu(String structureName);
}
