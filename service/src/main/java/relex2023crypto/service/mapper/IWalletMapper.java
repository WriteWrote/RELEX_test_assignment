package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.service.model.WalletDto;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface IWalletMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "sum", source = "currencySum")
    WalletDto fromEntity(WalletEntity entity);

    @Mapping(target = "user", ignore = true)
    @Mapping(target = "currencySum", source = "sum")
    WalletEntity toEntity(WalletDto dto);

    List<WalletDto> fromEntities(Iterable<WalletEntity> entities);

    @Mapping(target = "currencySum", source = "sum")
//    @Mapping(target = "id", source = "id")
//    @Mapping(target = "currencyId", source = "currencyId")
    WalletEntity merge(WalletDto dto, @MappingTarget WalletEntity entity);
}
