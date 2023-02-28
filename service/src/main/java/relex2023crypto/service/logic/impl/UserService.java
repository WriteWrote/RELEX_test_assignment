package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import relex2023crypto.db.entities.UserEntity;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.utils.AdminAccessProvider;
import relex2023crypto.service.mapper.IUserMapper;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.responses.SecretKeyDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String PASSWORD = "42";
    private final AdminAccessProvider provider;
    private final UserRepository rep;
    private final IUserMapper map;

    public UserService(AdminAccessProvider provider, UserRepository rep, IUserMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
    }

    @Override
    public SecretKeyDto createUser(UserDto dto) {
        logger.info("Requested creating new user {}",
                dto.getId());

        TextEncryptor encryptor = Encryptors.text(PASSWORD, dto.getLogin());
        String encryptedText = encryptor.encrypt(dto.getEmail());

        UserEntity entity = map.toEntity(dto);
        entity.setSecretKey(encryptedText);
        rep.save(entity);

        return new SecretKeyDto(encryptedText);
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
