package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.CurrencyEntity;
import relex2023crypto.db.entities.CurrencyEntity_;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity,Integer>,
        JpaRepository<CurrencyEntity,Integer> {
}
