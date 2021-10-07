package pl.mlopatka.messages.message;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageFactory messageFactory;
    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    @Override
    public long createMessage(MessageDto messageDto) {
        Message message = messageFactory.createMessage(messageDto.getAuthor(), messageDto.getText());
        message = messageRepository.save(message);
        return message.getId();
    }

    @Override
    public List<MessageDto> getMessages(String author) {
        List<Message> messages = messageRepository.findByAuthor(author);
        return messageMapper.map(messages);
    }

    @Override
    public List<MessageDto> getMessages(List<String> authors) {
        List<Message> messages = messageRepository.findByAuthorInOrderByCreationTime(authors);
        return messageMapper.map(messages);
    }
}
