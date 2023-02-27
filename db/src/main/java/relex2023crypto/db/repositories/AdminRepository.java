package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import relex2023crypto.db.entities.AdminEntity;
import relex2023crypto.db.entities.UserEntity;

import java.util.List;

@Repository
public interface AdminRepository extends CrudRepository<AdminEntity, Integer>, JpaRepository<AdminEntity, Integer> {

}
