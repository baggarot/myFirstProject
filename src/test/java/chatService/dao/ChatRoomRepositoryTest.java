//package chatService.dao;
//
//import chatService.model.ChatRoom;
//import chatService.repository.ChatRoomRepository;
//import lombok.val;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import static java.util.function.Predicate.not;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
//public class ChatRoomRepositoryTest {
//
//    @Autowired
//    private ChatRoomRepository roomRepository;
//
//    @Test
//    public void shouldReturnCorrectAllRoomList() {
//        val rooms = roomRepository.findAll();
//        assertThat(rooms).isNotNull().hasSize(0)
//                .allMatch(not(room -> room.getUsername().isEmpty()))
//                .allMatch(not(room -> room.getMessage().isEmpty()));
//        rooms.forEach(System.out::println);
//    }
//
//    @Test
//    public void shouldSaveAndLoadCorrectRoom() {
//        val expectedRoom = new ChatRoom();
//        expectedRoom.setUsername("testUsername");
//        expectedRoom.setMessage("Hello, world!");
//        val actualRoom = roomRepository.save(expectedRoom);
//        assertThat(actualRoom).isEqualTo(expectedRoom);
//    }
//}
