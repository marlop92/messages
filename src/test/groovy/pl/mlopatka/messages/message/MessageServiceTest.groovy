package pl.mlopatka.messages.message

import pl.mlopatka.utils.TestUtils
import spock.lang.Specification

class MessageServiceTest extends Specification {

    def messageFactory = Mock(MessageFactory)
    def messageMapper = Mock(MessageMapper)
    def messageRepository = Mock(MessageRepository)

    def service = new MessageServiceImpl(messageFactory, messageRepository, messageMapper)

    def "should create a message"() {
        given:
        def inputMessage = TestUtils.getMessageDto()
        def mockMessage = new Message();
        def persistedMessage = new Message.MessageBuilder().id(1).build()
        messageFactory.createMessage(inputMessage.getAuthor(), inputMessage.getText()) >> mockMessage
        messageRepository.save(mockMessage) >> persistedMessage

        when:
        def messageId = service.createMessage(inputMessage)

        then:
        messageId == 1
    }

    def "should map msg into dto"() {
        given:
        def inputAuthor = "author"
        def mockMessages = [new Message(), new Message()]
        def mockMessagesDto = TestUtils.getMessagesDto()
        messageRepository.findByAuthor(inputAuthor) >> mockMessages
        messageMapper.map(mockMessages) >> mockMessagesDto

        when:
        def messages = service.getMessages(inputAuthor)

        then:
        messages == mockMessagesDto
    }
}
