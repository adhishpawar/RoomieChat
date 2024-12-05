package com.adhish.chat.chat.controllers;

import com.adhish.chat.chat.entites.Message;
import com.adhish.chat.chat.entites.Room;
import com.adhish.chat.chat.repo.RoomRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
@CrossOrigin("http://localhost:3000")
public class RoomController {

    private RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //create Room
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody String roomId)
    {

        if(roomRepository.findByRoomId(roomId) != null)
        {
            //Room Already Exist
            return  ResponseEntity.badRequest().body("Room Already Exist");
        }
        //Create New Room

        Room room = new Room();
        room.setRoomId(roomId);

        Room savedRoom = roomRepository.save(room);
        return  ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    //Get Room :: Joining the Room
    //Can Get user Info to Store in DB as History
    @GetMapping("/{roomId}")
    public ResponseEntity<?> joinRoom(@PathVariable String roomId)
    {
        Room room = roomRepository.findByRoomId(roomId);

        if(room == null)
        {
            return  ResponseEntity.badRequest().body("Room Not Found");
        }

        return  ResponseEntity.ok(room);
    }

    //Get Message of Room

    @GetMapping("/{roomId}/messages")
    public ResponseEntity<List<Message>> getMessage(
            @PathVariable String roomId,
            @RequestParam(value = "page",defaultValue = "0", required = false) int page,
            @RequestParam(value= "size",defaultValue = "20", required = false) int size
    )
    {
        Room room = roomRepository.findByRoomId(roomId);
        if(room == null)
        {
            return  ResponseEntity.badRequest().build();
        }

        //get Messages
        //pagination
        List<Message> messages = room.getMessages();
        int start = Math.max(0,messages.size() - (page+1)*size);
        int end = Math.min(messages.size(),start + size);
        List<Message>paginatedMessages =  messages.subList(start,end);

        return ResponseEntity.ok(paginatedMessages);
    }




}
