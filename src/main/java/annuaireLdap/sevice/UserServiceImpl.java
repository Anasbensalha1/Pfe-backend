package annuaireLdap.sevice;

import annuaireLdap.entities.User;
import annuaireLdap.repo.UserRepo;
import annuaireLdap.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.NamingException;
import org.springframework.ldap.core.LdapTemplate;
import annuaireLdap.request.UserRequest;
import annuaireLdap.util.ConvertUtilitiesUser;

import javax.naming.InvalidNameException;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private LdapTemplate ldapTemplate;


    public UserDto getUserByCnrps(String req) {
        User u = userRepo.findByGovCNRPS(req);

        UserDto userDto = ConvertUtilitiesUser.convertUserToUserDto(u);
        return userDto;

    }

    public String addUser(UserRequest uReq) throws InvalidNameException, NamingException {
        User newUser = ConvertUtilitiesUser.convertUserRequestToUser(uReq);
        ldapTemplate.create(newUser);

        return newUser.getId().toString();
    }

    public String updateUser(UserDto userDto) throws InvalidNameException {
        User getUserToUpdate = userRepo.findByGovCNRPS(userDto.getGovCNRPS());
        userDto.setUid(getUserToUpdate.getUid());
        userDto.setGovCNRPS(getUserToUpdate.getGovCNRPS());
        User userUpdate = ConvertUtilitiesUser.convertUserDtoToUser(userDto);
        User updateUser = userRepo.save(userUpdate);
        return updateUser.getId().toString();
    }

    public List<UserDto> getAllUser() {
        List<User> usersList = userRepo.findAll();
        List<UserDto> listUserDto = ConvertUtilitiesUser.convertListUserToListUserDto(usersList);
        return listUserDto;
    }

    @Override
    public UserDto getUserByCnLangFr(String req) {
        User u = userRepo.findByCnLangFr(req);
        UserDto userDto = ConvertUtilitiesUser.convertUserToUserDto(u);
        return userDto;
    }

    @Override
    public UserDto getUserByUid(String req) {
        User u = userRepo.findByUid(req);
        UserDto userDto = ConvertUtilitiesUser.convertUserToUserDto(u);
        return userDto;
    }


    @Override
    public UserDto login(String req, String ps) {
        User u = userRepo.findByMail(req);
        if (u == null) {
            return null;
        } else {
            String password = new String(u.getUserPassword());
            if (password.equals(ps)) {
                UserDto userDto = ConvertUtilitiesUser.convertUserToUserDto(u);
                return userDto;
            }
        }
        return null;
    }

    @Override
    public void deleteUserByUid(String id) {
        userRepo.deleteByUid(id);
    }


}
