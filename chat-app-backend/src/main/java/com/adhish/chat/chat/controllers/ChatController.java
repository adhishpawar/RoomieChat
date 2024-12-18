package com.adhish.chat.chat.controllers;

import com.adhish.chat.chat.entites.Message;
import com.adhish.chat.chat.entites.Room;
import com.adhish.chat.chat.playload.MessageRequest;
import com.adhish.chat.chat.repo.RoomRepository;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Controller
@CrossOrigin("http://localhost:3000")
public class ChatController {

    private RoomRepository roomRepository;

    public ChatController(RoomRepository roomRepository)
    {
        this.roomRepository = roomRepository;
    }

    //for sending and revceving Message

    @MessageMapping("/sendMessage/{roomId}") // --> app/sendMessage/roomId
    @SendTo("/topic/room/{roomId}")    //--> Subscription of Message
    public Message sendMessage(
            @DestinationVariable String roomId,
            @RequestBody MessageRequest request
    )
    {
            Room room = roomRepository.findByRoomId(request.getRoomId());

            Message message = new Message();
            message.setContent(request.getContent());
            message.setSender(request.getSender());
            message.setTimeStamp(LocalDateTime.now());

            if(room != null)
            {
                room.getMessages().add(message);
                roomRepository.save(room);
            }
            else {
                throw new RuntimeException("Room not Found...!!");
            }
            return message;
    }
}
