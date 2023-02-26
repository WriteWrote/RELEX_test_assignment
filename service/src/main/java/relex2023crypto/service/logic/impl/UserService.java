package relex2023crypto.service.logic.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.mapper.IUserMapper;
import relex2023crypto.service.model.UserDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository rep;
    private final IUserMapper map;

    @Autowired
    public UserService(UserRepository rep, IUserMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public UserDto createAdmin(Integer requestingUserId, UserDto dto) {
        logger.info("Requested creating new admin by {}, access: {}",
                requestingUserId, "access");
        return Optional.of(dto)
                .map(map::toEntity)
                .map(rep::save)
                .map(map::fromEntity)
                .orElseThrow();
    }

    @Override
    public void deleteAdmin(Integer requestingUserId, Integer adminId) {
        logger.info("Requested deleting admin {} by user {}, access: {}",
                adminId, requestingUserId, "access");
        rep.deleteById(adminId);
    }

    @Override
    public List<UserDto> getAllAdmins(Integer requestingUserId) {
        logger.info("Requested all admins info by user {}, access: {}",
                requestingUserId, "access");
        return Optional.of(rep.findAll())
                .map(map::fromEntities)
                .orElseThrow();
    }
}
