package com.codestates.hello_world;

import com.codestates.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("v1/messages")
@RestController
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper mapper;

    public MessageController(MessageService messageService,
                             MessageMapper mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMessage(
            @Valid @RequestBody MessagePostDto messagePostDto){
        Message message
                = messageService.createMessage(mapper.messageDtoToMessage(messagePostDto));
        return ResponseEntity.ok(mapper.messageToMessageResponseDto(message));
    }

    @GetMapping("/{message-id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String getMessage(@PathVariable("message-id") long messageId){
        Optional<Message> message = messageService.findById(messageId);
        Message finalMessage = message.orElse(new Message("잘못된 회원정보입니다."));
        return finalMessage.getMessage();
    }
}
