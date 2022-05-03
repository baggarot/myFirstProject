package chatService.service.impl;

import chatService.model.security.ChatUser;
import chatService.repository.ChatUserRepository;
import chatService.repository.RoleRepository;
import chatService.service.ChatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatUserServiceImpl implements ChatUserService {

    private final ChatUserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public ChatUser findById(long userId) {
        Optional<ChatUser> userFromDB = userRepository.findById(userId);
        return userFromDB.orElse(new ChatUser());
    }

    @Override
    public List<ChatUser> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public boolean saveUser(ChatUser user) {
        ChatUser userFromDB = userRepository.findByUsername(user.getUsername());
        if (userFromDB != null) return false;
        user.setRole(roleRepository.getById(2L));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }
}
