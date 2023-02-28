package relex2023crypto.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import relex2023crypto.service.logic.IUserService;
import relex2023crypto.service.logic.impl.UserService;
import relex2023crypto.service.model.requests.CreateUserDto;
import relex2023crypto.service.model.UserDto;
import relex2023crypto.service.model.responses.ResponseDto;
import relex2023crypto.service.model.responses.SecretKeyDto;

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
    public SecretKeyDto createUser(@RequestBody CreateUserDto dto) {
        return service.createUser(dto);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseDto<Integer> deleteUser(@PathVariable Integer userId) {
        return service.deleteUser(userId);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return service.getAllUsers();
    }
}
