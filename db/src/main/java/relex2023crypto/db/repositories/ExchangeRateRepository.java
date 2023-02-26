package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.ExchangeRateEntity;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRateEntity, Integer>,
        JpaRepository<ExchangeRateEntity, Integer> {
}
