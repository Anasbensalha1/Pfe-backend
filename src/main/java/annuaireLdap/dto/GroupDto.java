package annuaireLdap.dto;

import java.util.Set;

import lombok.Data;
@Data
public class GroupDto {
	private String id;
	private String cn;
	private String description;
	private Set<String> members;

}
