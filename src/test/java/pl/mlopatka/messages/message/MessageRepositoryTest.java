package pl.mlopatka.messages.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pl.mlopatka.test.template.PersistenceItTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageRepositoryTest extends PersistenceItTest {

    @Autowired
    private MessageRepository messageRepository;

    @BeforeEach
    void setup() {
        super.dbContainerSetup();
    }

    @Test
    @Transactional
    void shouldFindByAuthor() {
        // given
        String author = "MarcinPe";

        // when
        List<Message> messages = messageRepository.findByAuthor(author);

        // then
        assertEquals(3, messages.size());
    }

}