package br.com.ferry.controle.controller;

import java.util.List;
import java.util.NoSuchElementException;

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

import br.com.ferry.controle.model.JornadaTrabalho;
import br.com.ferry.controle.service.JornadaService;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController {

	private JornadaService jornadaService;

	public JornadaTrabalhoController(JornadaService jornadaService) {
		this.jornadaService = jornadaService;
	}

	@PostMapping
	public JornadaTrabalho createJornada(@RequestBody @Valid JornadaTrabalho jornadaTrabalho) {
		return jornadaService.saveJornada(jornadaTrabalho);
	}

	@GetMapping
	public List<JornadaTrabalho> getJornadaList() {
		return jornadaService.findAll();
	}

	@GetMapping("/{idJornada}")
	public ResponseEntity<JornadaTrabalho> getJornadaByID(@PathVariable("idJornada") Long idJornada) throws Exception {
		return ResponseEntity
				.ok(jornadaService.getById(idJornada).orElseThrow(() -> new NoSuchElementException("Not found!")));
	}

	@PutMapping
	public JornadaTrabalho updateJornada(@RequestBody @Valid JornadaTrabalho jornadaTrabalho) {
		return jornadaService.updateJornada(jornadaTrabalho);
	}

	@DeleteMapping("/{idJornada}")
	public ResponseEntity deleteByID(@PathVariable("idJornada") Long idJornada) throws Exception {
		try {
			jornadaService.deleteJornada(idJornada);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return (ResponseEntity<JornadaTrabalho>) ResponseEntity.ok();
	}
}
