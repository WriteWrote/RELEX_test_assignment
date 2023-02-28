package relex2023crypto.service.logic;

import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

public interface IAdminService {
    AdminDto createAdmin(Integer requestingUserId, AdminDto dto);

    ResponseDto deleteAdmin(Integer requestingUserId, Integer adminId);

    List<AdminDto> getAllAdmins(Integer requestingUserId);
}
