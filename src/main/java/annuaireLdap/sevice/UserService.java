package annuaireLdap.sevice;

import annuaireLdap.dto.UserDto;
import annuaireLdap.request.UserRequest;

import javax.naming.InvalidNameException;
import java.util.List;

public interface UserService {

	public UserDto getUserByCnrps(String req);

	public String addUser(UserRequest uReq) throws InvalidNameException;

	public String updateUser(UserDto userDto) throws InvalidNameException;

	public List<UserDto> getAllUser();
	public UserDto getUserByCnLangFr(String req);
	public UserDto getUserByUid(String req);
	public UserDto login(String req,String ps);
	public void deleteUserByUid(String id);
}
