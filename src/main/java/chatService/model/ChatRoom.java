package chatService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ROOM")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "USERNAME", nullable = false)
    private String username;

    @NotEmpty
    @Column(name = "MESSAGE", nullable = false)
    private String message;

    public ChatRoom(String username, String message) {
        this.username = username;
        this.message = message;
    }
}
