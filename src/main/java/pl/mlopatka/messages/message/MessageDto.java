package pl.mlopatka.messages.message;


import lombok.*;
import org.springframework.lang.NonNull;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    @NonNull
    private String author;
    @NonNull
    private String text;

    private ZonedDateTime creationTime;
}
