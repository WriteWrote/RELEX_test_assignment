package relex2023crypto.service.logic.utils;

import relex2023crypto.db.repositories.AdminRepository;

public class AccessProvider {
    //don't laugh, this is just util with one method
    AdminRepository repository;

    public boolean checkAccessByUserId(Integer id) {
        return repository.findAll().contains(id);
    }

    public boolean checkAccessByUserSecretKey(String secretKey) {
        return secretKey.equals(repository.findBySecretKey(secretKey).getSecretKey());
    }
}
