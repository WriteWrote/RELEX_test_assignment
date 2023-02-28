package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.utils.AccessProvider;
import relex2023crypto.service.mapper.IUserMapper;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final AccessProvider provider;
    private final UserRepository rep;
    private final IUserMapper map;

    public UserService(AccessProvider provider, UserRepository rep, IUserMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
    }

    @Override
    public UserDto createUser(UserDto dto) {
        logger.info("Requested creating new user {}",
                dto.getId());
        return Optional.of(dto)
                .map(map::toEntity)
                .map(rep::save)
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public ResponseDto<Integer> deleteUser(Integer userId) {
        logger.info("Requested deleting user {}",
                userId);
        rep.deleteById(userId);
        return new ResponseDto<Integer>("Successfully deleted user {}", userId);
    }

    @Override
    public List<UserDto> getAllUsers() {
        logger.info("Requested list of all users");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }
}
