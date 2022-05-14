package chatService.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {

    private MessageType type;
    private String username;
    private String message;
}
