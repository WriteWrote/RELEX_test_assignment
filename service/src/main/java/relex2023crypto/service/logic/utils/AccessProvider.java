package relex2023crypto.service.logic.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import relex2023crypto.db.repositories.AdminRepository;

@Component
public class AccessProvider {
    //don't laugh, this is just util with one method
    AdminRepository repository;

    @Autowired
    public AccessProvider(AdminRepository repository) {
        this.repository = repository;
    }

    public boolean checkAccessByUserId(Integer id) {
        return repository.findAll().contains(id);
    }

    public boolean checkAccessByUserSecretKey(String secretKey) {
        return secretKey.equals(repository.findBySecretKey(secretKey).getSecretKey());
    }
}
