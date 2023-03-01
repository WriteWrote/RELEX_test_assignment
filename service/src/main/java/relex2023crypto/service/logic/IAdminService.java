package relex2023crypto.service.logic;

import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.SecretKeyDto;

import java.util.List;

public interface IAdminService {
    ResponseDto<SecretKeyDto> createAdmin(Integer requestingUserId, AdminDto dto);

    ResponseDto<Integer> deleteAdmin(Integer requestingUserId, Integer adminId);

    ResponseDto<List<AdminDto>> getAllAdmins(Integer requestingUserId);
}
