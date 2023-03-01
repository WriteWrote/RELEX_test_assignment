package relex2023crypto.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import relex2023crypto.db.entities.WalletEntity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
public interface WalletRepository extends CrudRepository<WalletEntity, Integer>, JpaRepository<WalletEntity, Integer> {
    List<WalletEntity> findAllByUserId(@NotNull Integer user_id);

    List<WalletEntity> findAllByCurrencyId(@NotEmpty(message = "currencyId in WalletEntity must not be empty") Integer currencyId);
}
