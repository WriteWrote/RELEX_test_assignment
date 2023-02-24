package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRateRepository, Integer>, JpaRepository<ExchangeRateRepository, Integer> {
}
