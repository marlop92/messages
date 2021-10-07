package pl.mlopatka.messages.message

import org.mapstruct.factory.Mappers
import spock.lang.Specification
import spock.util.time.MutableClock

import java.time.ZonedDateTime

import static pl.mlopatka.utils.TestUtils.FIXED_INSTANT

class MessageMapperTest extends Specification {

    def clock = new MutableClock(FIXED_INSTANT)
    def mapper = Mappers.getMapper(MessageMapper.class)

    def "should map to message"() {
        def message = new Message.MessageBuilder()
                .id(1)
                .author("author")
                .text("text")
                .creationTime(ZonedDateTime.now(clock)).build()

        when:
        def resultMessageDto = mapper.map(message);

        then:
        resultMessageDto.getAuthor() == "author"
        resultMessageDto.getText() == "text"
        resultMessageDto.getCreationTime() == ZonedDateTime.now(clock)
    }

    def "should map to messages"() {
        def messages = [
                new Message.MessageBuilder().id(1).author("author1").text("text1")
                    .creationTime(ZonedDateTime.now(clock)).build(),
                new Message.MessageBuilder().id(2).author("author2").text("text2")
                        .creationTime(ZonedDateTime.now(clock)).build()]

        when:
        def resultMessagesDto = mapper.map(messages);

        then:
        resultMessagesDto.size() == 2
        resultMessagesDto.get(0).getAuthor() == "author1"
        resultMessagesDto.get(0).getText() == "text1"
        resultMessagesDto.get(0).getCreationTime() == ZonedDateTime.now(clock)
        resultMessagesDto.get(1).getAuthor() == "author2"
        resultMessagesDto.get(1).getText() == "text2"
        resultMessagesDto.get(1).getCreationTime() == ZonedDateTime.now(clock)
    }
}
