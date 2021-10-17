package pl.mlopatka.messages.user;

import java.util.List;

public interface UserRepository {

    List<?> getFollowed();
}
