package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.TransactionEntity;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity,Integer>,
        JpaRepository<TransactionEntity, Integer> {
}
