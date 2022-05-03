package chatService.service.impl;

import chatService.model.ChatRoom;
import chatService.repository.ChatRoomRepository;
import chatService.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {

    private final ChatRoomRepository roomRepository;


    @Override
    public List<ChatRoom> allMessage() {
        return roomRepository.findAll();
    }

    @Override
    public boolean saveMessage(ChatRoom room) {
        roomRepository.save(room);
        return true;
    }
}
