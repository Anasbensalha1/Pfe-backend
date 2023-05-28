package annuaireLdap.Controller;

import java.util.List;


import annuaireLdap.dto.UserDto;
import annuaireLdap.request.UserRequest;
import annuaireLdap.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.naming.InvalidNameException;
import javax.naming.NamingException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	MessageSource messageSource;
	@Autowired
	UserService userService;

	@GetMapping(path = "/find-user-by-govcnrps/{govCNRPS}")
	public UserDto findUserByGovCnrps(@PathVariable("govCNRPS") String govCNRPS) throws Exception {

		UserDto user = userService.getUserByCnrps(govCNRPS);
		return user;
	}

	/*@GetMapping(path = "/find-user-by-govcnrps")
	public UserDto findUserByGovCnrps() throws Exception {

		UserDto user = userService.getUserByCnrps("1234567890");
		return user;
	}*/
	@GetMapping(path = "/find-all-user")
	public List<UserDto> findAllUser() throws Exception {
		List<UserDto> userList = userService.getAllUser();
		return userList;
	}

	/*@PostMapping(path = "/add-user")
	public String adduser() throws InvalidNameException, NamingException {
		UserRequest userRequest = new UserRequest();

		userRequest.setId("uid=009,ou=users");
		userRequest.setGovCNRPS("0003");
		userRequest.setCn("cn");
		userRequest.setSn("Sn");


		return userService.addUser(userRequest);
	}*/
	/*@PostMapping(path = "/add-user")
	public ResponseEntity<String> addUSer(@RequestBody UserDto userDto){
		return
	}*/
	@PostMapping(path = "/add-user")
	public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest) throws InvalidNameException, NamingException {
		return new ResponseEntity<String>(userService.addUser(userRequest), HttpStatus.CREATED);
	}

	/*@GetMapping(path = "/find-user-by-cnLangFr/{cnLangFr}")
	public UserDto findUserByCnLangFr(@PathVariable("cnLangFr") String cnLangFr) throws Exception{
		UserDto user =userService.getUserByCnLangFr(cnLangFr);
		return user;
	}*/
	@GetMapping(path = "/find-user-by-cnLangFr")
	public UserDto findUserByCnLangFr() throws Exception {
		UserDto user = userService.getUserByCnLangFr("anas");
		return user;
	}

	@GetMapping(path = "/find-user-by-uid/{uid}")
	public UserDto findUserByUid(@PathVariable("uid") String uid) throws Exception {
		UserDto user = userService.getUserByUid(uid);
		return user;
	}

	@CrossOrigin(origins = "*")
	@PostMapping(path = "/login")
	public ResponseEntity<UserDto> checkCred(@RequestBody UserRequest userRequest) {
		String password = new String(userRequest.getPassword());

		return new ResponseEntity<UserDto>(userService.login(userRequest.getMail(), password), HttpStatus.CREATED);

	}

	@DeleteMapping("delete-user/{uid}")
	public void deleteUserByUid(@PathVariable(name = "uid") String  userUid) {
		userService.deleteUserByUid(userUid);
	}



}
