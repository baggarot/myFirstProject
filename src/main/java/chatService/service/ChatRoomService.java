package chatService.service;

import chatService.model.ChatRoom;

import java.util.List;

public interface ChatRoomService {

    List<ChatRoom> allMessage();
    boolean saveMessage(ChatRoom room);
}
