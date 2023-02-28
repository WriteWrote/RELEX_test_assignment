package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.UserEntity;

import javax.validation.constraints.NotEmpty;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer>, JpaRepository<UserEntity, Integer> {
    Boolean existsByEmailIgnoreCase(@NotEmpty(message = "email must not be empty") String email);

    Boolean existsByIdIsNotAndEmailIgnoreCase(Integer id, @NotEmpty(message = "email must not be empty") String email);
}
