package com.mbanya.training.room.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mbanya.training.room.repositories.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
