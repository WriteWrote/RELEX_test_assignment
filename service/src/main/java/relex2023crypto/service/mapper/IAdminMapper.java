package relex2023crypto.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import relex2023crypto.db.entities.AdminEntity;
import relex2023crypto.service.model.AdminDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IAdminMapper {
    AdminDto fromEntity(AdminEntity entity);

    AdminEntity ToEntity(AdminDto dto);

    List<AdminDto> fromEntities(Iterable<AdminEntity> entities);
}
