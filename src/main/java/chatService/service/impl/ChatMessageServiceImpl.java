package chatService.service.impl;

import chatService.model.ChatMessage;
import chatService.repository.ChatMessageRepository;
import chatService.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository messageRepository;


    @Override
    public List<ChatMessage> allMessage() {
        return messageRepository.findAll();
    }

    @Override
    public void saveMessage(ChatMessage message) {
        messageRepository.save(message);
    }
}
