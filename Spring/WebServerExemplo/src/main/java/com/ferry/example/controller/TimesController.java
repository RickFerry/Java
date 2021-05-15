package com.ferry.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferry.example.entities.Times;
import com.ferry.example.entities.dto.TimesDto;
import com.ferry.example.repository.TimesRepository;

@RestController
@RequestMapping("/api")
public class TimesController {

	@Autowired
	private TimesRepository tRep;
	
	@GetMapping("/times")
	public ResponseEntity<List<TimesDto>> getAllTimes(){
		
		List<Times> lista = tRep.findAll();
		
		List<TimesDto> novaLista = converteListaTimes(lista);
		
		return ResponseEntity.ok().body(novaLista);
	}
	
	@GetMapping("/times/{id}")
	public ResponseEntity<TimesDto> getTime(@PathVariable(value = "id") Integer id) {
		Times time = tRep.findById(id).orElseThrow(() -> new ResourceNotFoundException(id + "invalido"));
		
		TimesDto dto = converteTime(time);
		
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping("/times")
	public ResponseEntity<String> crudTimes(@Valid @RequestBody Times t){
		
		String saida = tRep.spCrudTimes(t.getCod(), t.getId(), t.getNome(), t.getCidade());
	
		return ResponseEntity.ok().body(saida);
	}
	
	@SuppressWarnings("unused")
	private TimesDto converteTime(Times t) {
		TimesDto tDto = new TimesDto();
		tDto.setId(t.getId());
		tDto.setNome(t.getNome());
		tDto.setCidade(t.getCidade());
		
		return tDto;
 	}
	
	@SuppressWarnings("unused")
	private List<TimesDto> converteListaTimes(List<Times> listaTimes){

		List<TimesDto> lista = new ArrayList<>();
		
		for (TimesDto t : lista) {
			TimesDto dto = new TimesDto();
			dto.setId(t.getId());
			dto.setNome(t.getNome());
			dto.setCidade(t.getCidade());
			
			lista.add(dto);
		}
		return lista;
	}
}
