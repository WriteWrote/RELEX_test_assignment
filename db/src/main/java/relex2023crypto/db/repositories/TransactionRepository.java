package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.TransactionEntity;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer>,
        JpaRepository<TransactionEntity, Integer> {
    List<TransactionEntity> findAllByUserId(@NotNull(message = "userId in UserEntity must not be empty") Integer user_id);
    List<TransactionEntity> findAllByDateBetween(@NotNull(message = "date1 must not be null") Date date,
                                                 @NotNull(message = "date2 must not be null") Date date2);
}
