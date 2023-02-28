package relex2023crypto.service.logic;

import relex2023crypto.service.model.requests.CreateUserDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.responses.SecretKeyDto;

import java.util.List;

public interface IUserService {
    SecretKeyDto createUser(CreateUserDto dto);

    ResponseDto<Integer> deleteUser(Integer userId);

    List<UserDto> getAllUsers();
}
