package relex2023crypto.service.logic;

import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;

import java.util.List;

public interface IUserService {
    UserDto createUser(UserDto dto);

    ResponseDto deleteUser(Integer userId);

    List<UserDto> getAllUsers();
}
