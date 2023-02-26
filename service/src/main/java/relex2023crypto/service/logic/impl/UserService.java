package relex2023crypto.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.UserRepository;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.mapper.IUserMapper;

@Service
public class UserService implements IUserService {
    private final UserRepository rep;

    private final IUserMapper map;

    @Autowired
    public UserService(UserRepository rep, IUserMapper map) {
        this.rep = rep;
        this.map = map;
    }
}
