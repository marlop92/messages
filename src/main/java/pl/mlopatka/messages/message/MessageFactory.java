package pl.mlopatka.messages.message;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.ZonedDateTime;

@Service
@AllArgsConstructor
public class MessageFactory {

    private final Clock clock;

    public Message createMessage(String author, String text) {
        Message message = new Message();
        message.setAuthor(author);
        message.setCreationTime(ZonedDateTime.now(clock));
        message.setText(text);

        return message;
    }
}
