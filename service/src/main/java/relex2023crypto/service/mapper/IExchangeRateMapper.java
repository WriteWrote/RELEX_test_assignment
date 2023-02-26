package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import relex2023crypto.db.entities.ExchangeRateEntity;
import relex2023crypto.service.model.ExchangeRateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IExchangeRateMapper {
    ExchangeRateDto fromEntity(ExchangeRateEntity entity);

    ExchangeRateEntity toEntity(ExchangeRateDto dto);

    List<ExchangeRateDto> fromEntities(Iterable<ExchangeRateEntity> entities);
}
