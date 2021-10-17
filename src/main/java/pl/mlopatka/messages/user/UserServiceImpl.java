package pl.mlopatka.messages.user;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<UserDto> getFollowedUsers(String id) {
        return Collections.emptyList();
    }
}
