package pl.mlopatka.messages.message;

import java.util.List;

public interface MessageService {

    long createMessage(MessageDto messageDto);

    List<MessageDto> getMessages(String author);

    List<MessageDto> getMessages(List<String> authors);
}
