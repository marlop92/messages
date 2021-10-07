package pl.mlopatka.messages.message;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.ZonedDateTime;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class MessageDto {

    @NonNull
    private String author;
    @NonNull
    private String text;

    private ZonedDateTime creationTime;
}
