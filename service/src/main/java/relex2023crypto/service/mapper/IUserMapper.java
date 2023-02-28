package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import relex2023crypto.db.entities.UserEntity;
import relex2023crypto.service.model.requests.CreateUserDto;
import relex2023crypto.service.model.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    @Mapping(target = "wallets", source = "wallets")
    @Mapping(target = "transactions", source = "transactionsHistory")
    @Mapping(target = "email", source = "email")
    UserDto fromEntity(UserEntity entity);

    @Mapping(target = "secretKey", ignore = true)
    @Mapping(target = "email", source = "email")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "wallets", source = "wallets")
    @Mapping(target = "transactionsHistory", source = "transactions")
    UserEntity toEntity(UserDto dto);

    @Mapping(target = "secretKey", ignore = true)
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "login", source = "login")
    @Mapping(target = "wallets", source = "wallets")
    @Mapping(target = "transactionsHistory", source = "transactions")
    UserEntity toEntity(CreateUserDto dto);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
