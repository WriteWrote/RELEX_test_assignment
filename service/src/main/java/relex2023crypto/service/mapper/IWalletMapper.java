package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import relex2023crypto.db.entities.WalletEntity;
import relex2023crypto.service.model.WalletDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IWalletMapper {
    WalletDto fromEntity(WalletEntity entity);

    WalletEntity toEntity(WalletDto dto);

    List<WalletDto> fromEntities(Iterable<WalletEntity> entities);
}
