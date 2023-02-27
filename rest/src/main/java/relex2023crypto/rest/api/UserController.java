package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.impl.UserService;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.ResponseDto;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    @PostMapping("/new")
    public UserDto createUser(@RequestBody UserDto dto){
        return service.createUser(dto);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseDto deleteUser(@PathVariable Integer userId){
        return service.deleteUser(userId);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers(){
        return service.getAllUsers();
    }
}
