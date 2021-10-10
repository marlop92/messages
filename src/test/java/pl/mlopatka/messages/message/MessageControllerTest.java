package pl.mlopatka.messages.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.mlopatka.test.config.Config.OBJECT_MAPPER;

@WebMvcTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MessageController messageController;

    @Test
    void shouldGetMessages() throws Exception {
        when(messageController.getMessages(any())).thenReturn(List.of(new MessageDto()));

        mockMvc.perform(MockMvcRequestBuilders.get("/messages/1")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void shouldCreateMessage() throws Exception {
        when(messageController.createMessage(any())).thenReturn(1L);
        MessageDto messageDto = new MessageDto.MessageDtoBuilder().author("author").text("Hello!").build();

        mockMvc.perform(MockMvcRequestBuilders.post(
                "/messages")
                        .content(OBJECT_MAPPER.writeValueAsString(messageDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print()).andExpect(status().isCreated());
    }
}
