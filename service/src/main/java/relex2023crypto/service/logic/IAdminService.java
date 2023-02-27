package relex2023crypto.service.logic;

import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.ResponseDto;
import relex2023crypto.service.model.UserDto;

import java.util.List;

public interface IAdminService {
    AdminDto createAdmin(Integer requestingUserId, AdminDto dto);

    ResponseDto deleteAdmin(Integer requestingUserId, Integer adminId);

    List<AdminDto> getAllAdmins(Integer requestingUserId);



}
