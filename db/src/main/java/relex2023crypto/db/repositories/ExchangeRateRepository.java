package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.ExchangeRateEntity;

import javax.validation.constraints.NotEmpty;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRateEntity, Integer>,
        JpaRepository<ExchangeRateEntity, Integer> {
    ExchangeRateEntity findByCurrency1AndCurrency2(@NotEmpty(message = "currencyid1 in currencyEntity must not be empty") Integer currency1,
                                                   @NotEmpty(message = "currencyid2 in currencyEntity must not be empty") Integer currency2);
}
