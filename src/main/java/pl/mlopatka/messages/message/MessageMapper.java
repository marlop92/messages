package pl.mlopatka.messages.message;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    List<MessageDto> map(List<Message> messages);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(source = "message.author", target = "author")
    @Mapping(source = "message.text", target = "text")
    @Mapping(source = "message.creationTime", target = "creationTime")
    MessageDto map(Message message);

}
