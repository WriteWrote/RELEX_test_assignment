package relex2023crypto.rest.api;

import relex2023crypto.service.logic.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.responses.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("/users/{requestingUserId}/admins")
public class AdminController {
    private final IAdminService service;

    @Autowired
    public AdminController(IAdminService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseDto<AdminDto> createAdmin(@RequestBody AdminDto dto, @PathVariable Integer requestingUserId){
        return service.createAdmin(requestingUserId, dto);
    }
    @DeleteMapping("/delete/{adminId}")
    public ResponseDto<Integer> deleteAdmin(@PathVariable Integer requestingUserId,
                                   @PathVariable Integer adminId){
        return service.deleteAdmin(requestingUserId, adminId);
    }

    @GetMapping("/all")
    public ResponseDto<List<AdminDto>> getAllAdmins(@PathVariable Integer requestingUserId){
        return service.getAllAdmins(requestingUserId);
    }


}
