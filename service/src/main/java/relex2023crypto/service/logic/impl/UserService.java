package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.utils.AccessProvider;
import relex2023crypto.service.mapper.IUserMapper;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.responses.SecretKeyResponceDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private static final String PASSWORD = "42";
    private final AccessProvider provider;
    private final UserRepository rep;
    private final IUserMapper map;

    public UserService(AccessProvider provider, UserRepository rep, IUserMapper map) {
        this.provider = provider;
        this.rep = rep;
        this.map = map;
    }

    @Override
    public SecretKeyResponceDto createUser(UserDto dto) {
        logger.info("Requested creating new user {}",
                dto.getId());

        TextEncryptor encryptor = Encryptors.text(PASSWORD, dto.getLogin());
        String encryptedText = encryptor.encrypt(dto.getEmail());

        dto.setSecretKey(encryptedText);

        rep.save(map.toEntity(dto));

        return new SecretKeyResponceDto(encryptedText);
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
