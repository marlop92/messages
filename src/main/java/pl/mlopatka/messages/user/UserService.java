package pl.mlopatka.messages.user;

import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<UserDto> getFollowedUsers(String id);
}
