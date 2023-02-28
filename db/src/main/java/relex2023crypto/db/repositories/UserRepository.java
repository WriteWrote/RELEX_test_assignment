package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.UserEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer> {
    UserEntity findBySecretKey(@NotEmpty(message = "secret key must not be empty") String secretKey);
    Boolean existsBySecretKey(@NotEmpty(message = "secret key must not be empty") String secretKey);
    Boolean existsByEmailIgnoreCase(@NotEmpty(message = "email must not be empty") String email);

    Boolean existsByLoginIgnoreCase(@NotEmpty(message = "login must not be empty")
                                    @Size(min = 4, max = 50, message = "login must be from 4 to 50 characters")
                                    String login);

    Boolean existsByIdIsNotAndLoginIgnoreCase(Integer id,
                                              @NotEmpty(message = "login must not be empty")
                                              @Size(min = 4, max = 50, message = "login must be from 4 to 50 characters")
                                              String login);

    Boolean existsByIdIsNotAndEmailIgnoreCase(Integer id, @NotEmpty(message = "email must not be empty") String email);
}
