package pl.mlopatka.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.testcontainers.shaded.com.fasterxml.jackson.core.type.TypeReference;
import pl.mlopatka.messages.message.Message;
import pl.mlopatka.messages.message.MessageDto;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

public class TestUtils {

    public final static Instant FIXED_INSTANT = Instant.parse("2020-01-05T10:45:00+02:00");
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.findAndRegisterModules();
    }

    public static MessageDto getMessageDto() throws IOException {
        return readValue("messageDto.json", MessageDto.class);
    }

    public static List<MessageDto> getMessagesDto() throws IOException {
        return readValue("messagesDto.json", List.class);
    }

    public static Message getMessage() throws IOException {
        return readValue("message.json", Message.class);
    }

    public static List<Message> getMessages() throws IOException {
        return readValueFromList("messages.json", Message.class);
    }

    private static <T> List<T> readValueFromList(String filename, Class<T> tClass) throws IOException {
        InputStream inJson = new ClassPathResource(filename).getInputStream();
        return OBJECT_MAPPER.readValue(inJson,
                OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, tClass));
    }

    private static <T> T readValue(String filename, Class<T> tClass) throws IOException {
        InputStream inJson = new ClassPathResource(filename).getInputStream();
        return OBJECT_MAPPER.readValue(inJson, tClass);
    }
}
