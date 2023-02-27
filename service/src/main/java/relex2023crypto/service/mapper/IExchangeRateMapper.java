package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import relex2023crypto.db.entities.ExchangeRateEntity;
import relex2023crypto.service.model.ExchangeRateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IExchangeRateMapper {
    @Mapping(target = "currency_id1", source = "currency1")
    @Mapping(target = "currency_id2", source = "currency2")
    ExchangeRateDto fromEntity(ExchangeRateEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "currency1", source = "currency_id1")
    @Mapping(target = "currency2", source = "currency_id2")
    ExchangeRateEntity toEntity(ExchangeRateDto dto);

    List<ExchangeRateDto> fromEntities(Iterable<ExchangeRateEntity> entities);
    @Mapping(target = "currency1", source = "currency_id1")
    @Mapping(target = "currency2", source = "currency_id2")
    ExchangeRateEntity merge(ExchangeRateDto dto, @MappingTarget ExchangeRateEntity entity);
}
