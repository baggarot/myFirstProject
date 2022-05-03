package chatService.dao;

import chatService.model.security.ChatUser;
import chatService.model.security.Role;
import chatService.repository.ChatUserRepository;
import chatService.repository.RoleRepository;
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
public class ChatUserRepositoryTest {

    @Autowired
    private ChatUserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturnCorrectAllUserList() {
        val users = userRepository.findAll();
        assertThat(users).isNotNull().hasSize(1)
                .allMatch(not(user -> user.getUsername().isEmpty()))
                .allMatch(not(user -> user.getPassword().isEmpty()))
                .allMatch(not(user -> user.getRole().getName().isEmpty()));
        users.forEach(System.out::println);
    }

    @Test
    public void shouldFindExpectedUserByUsername() {
        String newUsername = "admin";
        val actualUsername = userRepository.findByUsername(newUsername);
        assertThat(actualUsername).isNotNull()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("username", newUsername)
                .hasFieldOrPropertyWithValue("password",
                        "$2a$10$tYtur424.uD.YYPO8O7nQum2epc8fePSfk60JuhrHu84hpvSh8YSG")
                .hasFieldOrPropertyWithValue("confirmPassword", null)
                .hasFieldOrPropertyWithValue("role", new Role(1L, "ADMIN"));
    }

    @Test
    public void shouldSaveAndLoadCorrectUser() {
        val expectedUser = new ChatUser();
        expectedUser.setUsername("user");
        expectedUser.setPassword("$2a$10$Jr55VDwAHT1hUJjChhuZ9O0/8Vjv.zRiw6S0z9Zym/pB0.rAxetCy");
        expectedUser.setConfirmPassword(null);
        expectedUser.setRole(roleRepository.getById(2L));
        val actualUser = userRepository.save(expectedUser);
        assertThat(actualUser).isEqualTo(expectedUser);
    }
}
