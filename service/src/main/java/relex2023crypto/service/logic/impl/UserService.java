package relex2023crypto.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.mapper.IUserMapper;
import relex2023crypto.service.model.UserDto;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository rep;

    private final IUserMapper map;

    @Autowired
    public UserService(UserRepository rep, IUserMapper map) {
        this.rep = rep;
        this.map = map;
    }

    @Override
    public UserDto createAdmin(Integer requestingUserId, UserDto dto) {
        return null;
    }

    @Override
    public UserDto deleteAdmin(Integer requestingUserId, Integer adminId) {
        return null;
    }

    @Override
    public List<UserDto> getAllAdmins(Integer requestingUserId) {
        return null;
    }
}
