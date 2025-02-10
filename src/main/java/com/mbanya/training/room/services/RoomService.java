package com.mbanya.training.room.services;

import lombok.extern.slf4j.Slf4j;

import com.mbanya.training.room.RoomMapper;
import com.mbanya.training.room.dto.RoomDto;
// import com.mbanya.training.room.repositories.Quality;
import com.mbanya.training.room.repositories.RoomRepository;
// import com.mbanya.training.room.repositories.Type;
import com.mbanya.training.room.repositories.model.Room;

import java.util.List;
import java.util.Optional;

import org.springframework.data.convert.TypeMapper;
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

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }

    public Room updateRoom(Long id, RoomDto request) {
        Optional<Room> existingRoomOpt = roomRepository.findById(id);
        if (existingRoomOpt.isPresent()) {
            Room existingRoom = existingRoomOpt.get();
    
            // Mettre à jour les champs
            existingRoom.setName(request.getName());
            existingRoom.setDescription(request.getDescription());
            existingRoom.setLocation(request.getLocation());
            existingRoom.setPrice(request.getPrice());
    
            // Utiliser RoomMapper pour convertir Quality et Type
            Room updatedRoom = RoomMapper.updateRoomFromDto(existingRoom, request);
    
            return roomRepository.save(updatedRoom);
        } else {
            throw new RuntimeException("Chambre non trouvée avec l'ID : " + id);
        }
    }
}

