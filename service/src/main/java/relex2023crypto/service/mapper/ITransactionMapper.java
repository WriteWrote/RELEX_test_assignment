package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import relex2023crypto.db.entities.TransactionEntity;
import relex2023crypto.service.model.TransactionDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITransactionMapper {
    @Mapping(target = "sum", source = "currencySum")
    @Mapping(target = "secretKey", source = "user.secretKey")
    TransactionDto fromEntity(TransactionEntity entity);


    @Mapping(target = "currencySum", source = "sum")
    @Mapping(target = "user", ignore = true)
    TransactionEntity toEntity(TransactionDto dto);

    List<TransactionDto> fromEntities(Iterable<TransactionEntity> entities);
}
