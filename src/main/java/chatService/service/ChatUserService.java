package chatService.service;

import chatService.model.security.ChatUser;

import java.util.List;

public interface ChatUserService {

    ChatUser findById(long userId);
    List<ChatUser> allUsers();
    boolean saveUser(ChatUser user);

}
