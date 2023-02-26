package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import relex2023crypto.db.entities.CurrencyEntity;
import relex2023crypto.service.model.CurrencyDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICurrencyMapper {
    CurrencyDto fromEntity(CurrencyEntity entity);

    CurrencyEntity toEntity(CurrencyDto dto);

    List<CurrencyDto> fromEntities(Iterable<CurrencyEntity> entities);
}
