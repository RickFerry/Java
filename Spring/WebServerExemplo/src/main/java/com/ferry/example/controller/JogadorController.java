package com.ferry.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferry.example.entities.Jogador;
import com.ferry.example.entities.dto.JogadorDto;
import com.ferry.example.entities.dto.TimesDto;
import com.ferry.example.repository.JogadorRepository;

@RestController
@RequestMapping("/api")
public class JogadorController {

	@Autowired
	private JogadorRepository jRep;
	
	@GetMapping("/jogador")
	public ResponseEntity<List<JogadorDto>> getAllJogador(){
		
		List<Jogador> lista = jRep.findJogadoresDataConv();
		
		List<JogadorDto> novaLista = converteListaJogador(lista);
		
		return ResponseEntity.ok().body(novaLista);
	}
	
	@GetMapping("/jogador/{id}")
	public ResponseEntity<JogadorDto> getJogador(@PathVariable(value = "id") Integer id) {

		Jogador j = jRep.findJogadorDataConv(id);
		
		JogadorDto dto = converteJogador(j);
		
		return ResponseEntity.ok().body(dto);
	}

	private JogadorDto converteJogador(Jogador j) {

		JogadorDto dto = new JogadorDto();
		dto.setCodigo(j.getCodigo());
		dto.setNomeJogador(j.getNome());
		dto.setSexo(j.getSexo());
		dto.setAltura(j.getAltura());
		dto.setDt_nasc(j.getDt_nasc());
		
		TimesDto tDto = new TimesDto();
		tDto.setId(j.getTimes().getId());
		tDto.setNome(j.getTimes().getNome());
		tDto.setCidade(j.getTimes().getCidade());
		
		dto.setTimes(tDto);		
		
		return dto;
	}
	
	@PostMapping("/jogador")
	public ResponseEntity<String> insertJogador(@Valid @RequestBody Jogador j){
		
		jRep.save(j);
	
		return ResponseEntity.ok().body("Inserido com sucesso.");
	}
	
	@PutMapping("/jogador")
	public ResponseEntity<String> updateJogador(@Valid @RequestBody Jogador j){
		
		jRep.save(j);
	
		return ResponseEntity.ok().body("Atualizado com sucesso.");
	}
	
	@DeleteMapping("/jogador")
	public ResponseEntity<String> deletarJogador(@Valid @RequestBody Jogador j){
		
		jRep.delete(j);
	
		return ResponseEntity.ok().body("Excluido com sucesso.");
	}

	private List<JogadorDto> converteListaJogador(List<Jogador> lista) {

		List<JogadorDto> list = new ArrayList<JogadorDto>();
		
		for (Jogador j : lista) {
			JogadorDto dto = new JogadorDto();
			dto.setCodigo(j.getCodigo());
			dto.setNomeJogador(j.getNome());
			dto.setSexo(j.getSexo());
			dto.setAltura(j.getAltura());
			dto.setDt_nasc(j.getDt_nasc());
			
			TimesDto tDto = new TimesDto();
			tDto.setId(j.getTimes().getId());
			tDto.setNome(j.getTimes().getNome());
			tDto.setCidade(j.getTimes().getCidade());
			
			dto.setTimes(tDto);
			list.add(dto);
		}
		return list;
	}
}
