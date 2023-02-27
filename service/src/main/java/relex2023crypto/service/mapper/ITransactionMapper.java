package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import relex2023crypto.db.entities.TransactionEntity;
import relex2023crypto.service.model.TransactionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {
    @Mapping(target = "sum", source = "currencySum")
    @Mapping(target = "userId", source = "user.id")
    TransactionDto fromEntity(TransactionEntity entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "currencySum", source = "sum")
    TransactionEntity toEntity(TransactionDto dto);

    List<TransactionDto> fromEntities(Iterable<TransactionEntity> entities);
}