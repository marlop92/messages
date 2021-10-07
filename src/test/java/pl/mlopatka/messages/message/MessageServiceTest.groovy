package pl.mlopatka.messages.message

import spock.lang.Specification
import spock.util.time.MutableClock

import java.time.ZonedDateTime

class MessageServiceTest extends Specification {

    def currentDate = ZonedDateTime.now()
    def clock = new MutableClock(currentDate)
    def messageFactory = new MessageFactory(clock)
    def messageMapper = new MessageMapperImpl()
    def messageRepository = Mock(MessageRepository)

    def service = new MessageServiceImpl(messageFactory, messageRepository, messageMapper)

    def "should map msg into dto"() {
        def msg = new Message();
        msg.setId(1)
        msg.setAuthor("author")
        msg.setCreationTime(ZonedDateTime.now(clock))
        msg.setText("text")

        def msgDto = new MessageDto();
        msgDto.setAuthor("author")
        msgDto.setCreationTime(ZonedDateTime.now(clock))
        msgDto.setText("text")

        messageRepository.findByAuthor("author") >> [msg]

        when:
        def messages = service.getMessages("author")

        then:
        messages.size() == 1
        messages.contains(msgDto)
    }
}
