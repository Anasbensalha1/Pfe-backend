package annuaireLdap.dto;

import annuaireLdap.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto{
private String uid;
private String id;
private String govCNRPS;
private String govCIN;
private String cn;
private String sn;
private String givenName;
private String cnLangFr;
private String cnLangAr;
private String snLangFr;
private String snLangAr;
private String givenNameLangFr;
private String givenNameLangAr;
private String mail;


}
