package relex2023crypto.service.logic;

import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.responses.SecretKeyResponceDto;

import java.util.List;

public interface IUserService {
    SecretKeyResponceDto createUser(UserDto dto);

    ResponseDto<Integer> deleteUser(Integer userId);

    List<UserDto> getAllUsers();
}
