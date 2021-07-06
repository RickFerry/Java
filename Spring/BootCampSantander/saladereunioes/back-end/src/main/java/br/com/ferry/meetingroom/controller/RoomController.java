package br.com.ferry.meetingroom.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferry.meetingroom.model.Room;
import br.com.ferry.meetingroom.service.RoomService;
import javassist.NotFoundException;

@RestController
@Transactional
@RequestMapping("/api/v1/rooms")
public class RoomController {
	
	private RoomService service;
	
	public RoomController(RoomService service) {
		this.service = service;
	}

	@GetMapping("/")
	public List<Room> listaTudo(){
		return service.listaTudo();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> pesquisar(@PathVariable Long id) {
		
		try {
			Room room = service.pesquisar(id);
			return ResponseEntity.ok().body(room);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok("Não foi possivel!!!");
	}

	@PostMapping("/")
	public ResponseEntity<String> adicionar(@Valid @RequestBody Room room) {
		service.adicionar(room);
		return ResponseEntity.ok().body("Sucesso!!!");
	}

	@PutMapping("/{id}")
	public ResponseEntity<Room> atualiza(@PathVariable Long id, String name, String start, String end) {
		return service.atualiza(id, name, start, end);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return service.remove(id);
	}

}
