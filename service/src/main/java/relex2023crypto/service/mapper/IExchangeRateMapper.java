package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import relex2023crypto.db.entities.ExchangeRateEntity;
import relex2023crypto.service.model.requests.ExchangeRateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IExchangeRateMapper {
    @Mapping(target = "requestingSecretKey", ignore = true)
    ExchangeRateDto fromEntity(ExchangeRateEntity entity);

    @Mapping(target = "id", ignore = true)
    ExchangeRateEntity toEntity(ExchangeRateDto dto);

    List<ExchangeRateDto> fromEntities(Iterable<ExchangeRateEntity> entities);

    @Mapping(target = "id", ignore = true)
    ExchangeRateEntity merge(ExchangeRateDto dto, @MappingTarget ExchangeRateEntity entity);
}
