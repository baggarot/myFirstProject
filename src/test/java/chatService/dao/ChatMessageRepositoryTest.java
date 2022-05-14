package chatService.dao;

import chatService.model.ChatMessage;
import chatService.repository.ChatMessageRepository;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static java.util.function.Predicate.not;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ChatMessageRepositoryTest {

    @Autowired
    private ChatMessageRepository messageRepository;

    @Test
    public void shouldReturnCorrectAllRoomList() {
        val messages = messageRepository.findAll();
        assertThat(messages).isNotNull().hasSize(0)
                .allMatch(not(message -> message.getUsername().isEmpty()))
                .allMatch(not(message -> message.getMessage().isEmpty()));
        messages.forEach(System.out::println);
    }

    @Test
    public void shouldSaveAndLoadCorrectRoom() {
        val expectedMessage = new ChatMessage();
        expectedMessage.setUsername("testUsername");
        expectedMessage.setMessage("Hello, world!");
        val actualMessage = messageRepository.save(expectedMessage);
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }
}
