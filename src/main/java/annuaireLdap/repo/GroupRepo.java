package annuaireLdap.repo;

import org.springframework.data.ldap.repository.LdapRepository;

import annuaireLdap.entities.Group;

public interface GroupRepo extends LdapRepository<Group>{
    Group findByCn(String username);
}
