package relex2023crypto.service.logic;

import relex2023crypto.service.model.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createAdmin(Integer requestingUserId, UserDto dto);

    UserDto deleteAdmin(Integer requestingUserId, Integer adminId);

    List<UserDto> getAllAdmins(Integer requestingUserId);

}
