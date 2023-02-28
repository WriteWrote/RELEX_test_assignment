package relex2023crypto.service.logic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relex2023crypto.db.repositories.AdminRepository;
import relex2023crypto.db.repositories.UserRepository;

@Component
public class AdminAccessProvider {
    //don't laugh, this is just util with one method
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminAccessProvider(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public boolean checkAdminAccessByUserId(Integer id) {
        return adminRepository.existsById(id);
    }

    public boolean checkAdminAccessByUserSecretKey(String secretKey) {
        return adminRepository.existsBySecretKey(secretKey);
    }
}
