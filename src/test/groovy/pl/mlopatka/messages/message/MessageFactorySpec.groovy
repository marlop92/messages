package pl.mlopatka.messages.message

import pl.mlopatka.test.utils.TestUtils;
import spock.lang.Specification
import spock.util.time.MutableClock
import java.time.ZonedDateTime

class MessageFactorySpec extends Specification {

    def clock = new MutableClock(TestUtils.FIXED_INSTANT)
    def factory = new MessageFactory(clock)

    def "should create message"() {
        def inputAuthor = "author"
        def inputText = "text"

        when:
        def message = factory.createMessage(inputAuthor, inputText)

        then:
        message.getAuthor() == inputAuthor
        message.getText() == inputText
        message.getCreationTime() == ZonedDateTime.now(clock)
    }
}
