package pl.mlopatka.messages.message

import pl.mlopatka.test.utils.TestUtils;
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class MessageMapperSpec extends Specification {

    def mapper = Mappers.getMapper(MessageMapper.class)

    def "should map to message"() {
        def inputMessage = TestUtils.getMessage()

        when:
        def resultMessageDto = mapper.map(inputMessage);

        then:
        resultMessageDto.getAuthor() == inputMessage.getAuthor()
        resultMessageDto.getText() == inputMessage.getText()
        resultMessageDto.getCreationTime() == inputMessage.getCreationTime()
    }

    def "should map to messages"() {
        def inputMessages = TestUtils.getMessages()

        when:
        def resultMessagesDto = mapper.map(inputMessages);

        then:
        resultMessagesDto.size() == 2
        resultMessagesDto.eachWithIndex({it, i ->
            it.getAuthor() == inputMessages.get(i).getAuthor()
            it.getText() == inputMessages.get(i).getText()
            it.getCreationTime() == inputMessages.get(i).getCreationTime()
        })
    }
}
