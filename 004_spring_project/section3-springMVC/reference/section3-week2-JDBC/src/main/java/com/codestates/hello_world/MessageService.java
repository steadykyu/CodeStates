package com.codestates.hello_world;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageService {
    // (1)
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);  // (2)
    }

    public Optional<Message> findById(long memberId){
        return messageRepository.findById(memberId);
    }
}
