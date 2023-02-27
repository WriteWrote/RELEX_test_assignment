package relex2023crypto.rest.api;

import relex2023crypto.service.logic.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.model.AdminDto;
import relex2023crypto.service.model.ResponseDto;
import relex2023crypto.service.model.UserDto;

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
    public AdminDto createAdmin(@RequestBody AdminDto dto, @PathVariable Integer requestingUserId){
        return service.createAdmin(requestingUserId, dto);
    }
    @DeleteMapping("/delete/{adminId}")
    public ResponseDto deleteAdmin(@PathVariable Integer requestingUserId,
                                   @PathVariable Integer adminId){
        return service.deleteAdmin(requestingUserId, adminId);
    }

    @GetMapping("/all")
    public List<AdminDto> getAllAdmins(@PathVariable Integer requestingUserId){
        return service.getAllAdmins(requestingUserId);
    }


}
