package annuaireLdap.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserRequest {
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
	private String password;
}
