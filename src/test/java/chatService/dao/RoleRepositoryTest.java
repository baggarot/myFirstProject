package chatService.dao;

import chatService.model.security.Role;
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
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void shouldReturnCorrectAllRoleList() {
        val roles = roleRepository.findAll();
        assertThat(roles).isNotNull().hasSize(2)
                .allMatch(not(role -> role.getName().isEmpty()));
        roles.forEach(System.out::println);
    }

    @Test
    public void shouldSaveAndLoadCorrectUser() {
        val expectedRole = new Role();
        expectedRole.setName("no role");
        val actualRole = roleRepository.save(expectedRole);
        assertThat(actualRole).isEqualTo(expectedRole);
    }

    @Test
    public void shouldDeleteRole() {
        val roleCountBefore = roleRepository.findAll().size();
        val newRole = new Role();
        newRole.setName("no role");
        val role = roleRepository.save(newRole);
        roleRepository.delete(role);
        val roleCountAfter = roleRepository.findAll().size();
        assertThat(roleCountBefore).isEqualTo(roleCountAfter);
    }
}
