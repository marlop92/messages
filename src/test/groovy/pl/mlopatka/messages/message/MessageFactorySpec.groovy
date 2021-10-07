package pl.mlopatka.messages.message


import spock.lang.Specification
import spock.util.time.MutableClock

import java.time.ZonedDateTime

import static pl.mlopatka.utils.TestUtils.FIXED_INSTANT

class MessageFactorySpec extends Specification {

    def clock = new MutableClock(FIXED_INSTANT)
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
