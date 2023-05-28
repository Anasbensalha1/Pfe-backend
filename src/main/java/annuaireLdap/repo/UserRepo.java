package annuaireLdap.repo;

import annuaireLdap.entities.User;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import javax.naming.Name;


@Repository
public interface UserRepo  extends LdapRepository<User> {
 User findByGovCNRPS(String Username);

 User findById(String id);

 void deleteByUid(String id);

 User findByCnLangFr(String cn);
 User findByUid(String id);
User findByMail(String mail);
 User findByuserPassword(String ps);



}
