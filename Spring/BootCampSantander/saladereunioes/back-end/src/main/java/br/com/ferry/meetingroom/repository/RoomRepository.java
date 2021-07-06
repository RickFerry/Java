package br.com.ferry.meetingroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.meetingroom.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long>{

}
