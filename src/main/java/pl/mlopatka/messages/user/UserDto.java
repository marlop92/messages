package pl.mlopatka.messages.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
@Builder
public class UserDto {

    @NonNull
    private String username;

}
