package com.mbanya.training.room;

import com.mbanya.training.room.dto.RoomDto;
import com.mbanya.training.room.repositories.Quality;
import com.mbanya.training.room.repositories.Type;
import com.mbanya.training.room.repositories.model.Room;

public class RoomMapper {

    public static Quality mapQuality(String quality) {
        if (quality == null) return null;
        switch (quality.toUpperCase()) {
            case "MEDIUM":
                return Quality.MEDIUM;
            case "HIGH_STANDING":
                return Quality.HIGH_STANDING;
            case "SIMPLE":
                return Quality.SIMPLE;
            default:
                return null;
        }
    }

    public static Room updateRoomFromDto(Room room, RoomDto request) {
        room.setQuality(mapQuality(request.getQuality()));
        room.setType(mapType(request.getType()));
        return room;
    }

    public static Type mapType(String type) {
        if (type == null) return null;
        switch (type.toUpperCase()) {
            case "ROOM":
                return Type.ROOM;
            case "SUITE":
                return Type.SUITE;
            case "HALL":
                return Type.HALL;
            default:
                return null;
        }
    }

    public static Room toEntity(RoomDto request) {
        return Room.builder()
            .name(request.getName())
            .description(request.getDescription())
            .location(request.getLocation())
            .price(request.getPrice())
            .quality(mapQuality(request.getQuality()))
            .type(mapType(request.getType()))
            .build();
    }
}
