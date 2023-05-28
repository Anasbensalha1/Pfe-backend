package annuaireLdap.request;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GroupRequest {
  private String id;
  private String cn;
  private String description;
  private Set<String> members;
  
}
