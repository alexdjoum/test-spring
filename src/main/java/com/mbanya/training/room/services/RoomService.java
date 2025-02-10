package com.mbanya.training.room.services;

import lombok.extern.slf4j.Slf4j;

import com.mbanya.training.room.RoomMapper;
import com.mbanya.training.room.dto.RoomDto;
// import com.mbanya.training.room.repositories.Quality;
import com.mbanya.training.room.repositories.RoomRepository;
// import com.mbanya.training.room.repositories.Type;
import com.mbanya.training.room.repositories.model.Room;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Slf4j
// @RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(RoomDto request) {
        Room room = RoomMapper.toEntity(request);
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}

