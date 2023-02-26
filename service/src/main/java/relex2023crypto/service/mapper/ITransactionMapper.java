package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import relex2023crypto.db.entities.TransactionEntity;
import relex2023crypto.service.model.TransactionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {
    TransactionDto fromEntity(TransactionEntity entity);

    TransactionEntity toEntity(TransactionDto dto);

    List<TransactionDto> fromEntities(Iterable<TransactionEntity> entities);
}
