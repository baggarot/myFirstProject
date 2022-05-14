package chatService.service;

import chatService.model.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    List<ChatMessage> allMessage();
    void saveMessage(ChatMessage message);
}
