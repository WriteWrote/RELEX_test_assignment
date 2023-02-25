package relex2023crypto.rest.api;

import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.impl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.impl.UserServiceImpl;
import relex2023crypto.service.model.UserDto;

import java.util.List;

@RestController
@RequestMapping("/users/{requestingUserId}/admins")
public class AdminController {
    private final IUserService service;

    @Autowired
    public AdminController(IUserService service) {
        this.service = service;
    }

    //todo: this three controllers should be available onlyfor users w/ admins secret_keys

    @PostMapping("/new")
    public UserDto createAdmin(@RequestBody UserDto dto, @PathVariable Integer requestingUserId){
        return service.createAdmin(dto, requestingUserId);
    }

    //Todo: create message responce here
    @DeleteMapping("/delete/{adminId}")
    public String deleteAdmin(@PathVariable Integer requestingUserId,
                            @PathVariable Integer adminId){
        return service.deleteAdmin(requestingUserId, adminId);
    }

    @GetMapping("/all")
    public List<UserDto> getAllAdmins(@PathVariable Integer requestingUserId){
        return service.getAllAdmins(requestingUserId);
    }


}
