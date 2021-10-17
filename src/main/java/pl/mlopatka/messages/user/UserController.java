package pl.mlopatka.messages.user;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}/followed")
    public List<UserDto> followed(@PathVariable String id) {
        return userService.getFollowedUsers(id);
    }

}
