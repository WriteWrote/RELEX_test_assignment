package relex2023crypto.service.logic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import relex2023crypto.db.repositories.AdminRepository;
import relex2023crypto.db.repositories.UserRepository;

@Component
public class AdminAccessProvider {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminAccessProvider(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public boolean checkAdminAccessByUserId(Integer id) {
        return adminRepository.existsById(id);
    }

    public boolean checkAdminAccessByUserSecretKey(String secretKey) {
        return adminRepository.existsBySecretKey(secretKey);
    }
}
