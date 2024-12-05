package com.adhish.chat.chat.repo;

import com.adhish.chat.chat.entites.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {

    //get Room using room id

    Room findByRoomId(String roomId);

}
