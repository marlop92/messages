package pl.mlopatka.messages.message;

import lombok.*;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    @NonNull
    private String author;
    @NonNull
    private String text;

    private ZonedDateTime creationTime;
}
