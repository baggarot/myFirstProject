package chatService.repository;

import chatService.model.security.ChatUser;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

    @EntityGraph(value = "ChatUser.role")
    ChatUser findByUsername(String username);
}
