package br.com.ferry.meetingroom.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ferry.meetingroom.model.Room;
import br.com.ferry.meetingroom.repository.RoomRepository;
import javassist.NotFoundException;

@Service
public class RoomService {
	
	private RoomRepository repository;

	public RoomService(RoomRepository repository) {
		this.repository = repository;
	}

	public List<Room> listaTudo() {
		return repository.findAll();
	}
	
	public Room pesquisar(Long id) throws NotFoundException {

		Room room = repository.findById(id).orElseThrow(() ->
								new NotFoundException("Não encontrado o id: " + id));
		return room;
	}

	public void adicionar(@Valid Room room) {
		repository.save(room);
	}

	public ResponseEntity<Room> atualiza(Long id, String name, String start, String end) {
		Room room = repository.findById(id).get();
		
		room.setName(name);
		room.setStart(start);
		room.setEnd(end);
		
		return ResponseEntity.ok(room);
	}

	public ResponseEntity<?> remove(Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.ok("Ok!!!");
	}

}
