package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import relex2023crypto.db.entities.UserEntity;
import relex2023crypto.service.model.UserDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserDto fromEntity(UserEntity entity);

    UserEntity toEntity(UserDto dto);

    List<UserDto> fromEntities(Iterable<UserEntity> entities);
}
