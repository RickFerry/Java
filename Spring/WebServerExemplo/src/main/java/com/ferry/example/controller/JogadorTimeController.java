package com.ferry.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferry.example.entities.JogadorTime;
import com.ferry.example.entities.dto.JogadorDto;
import com.ferry.example.entities.dto.TimesDto;
import com.ferry.example.repository.JogadorTimeRepository;

@RestController
@RequestMapping("/api")
public class JogadorTimeController {
	
	@Autowired
	private JogadorTimeRepository jTimeRep;

	@GetMapping("jogador/idade/{id}")
	public ResponseEntity<JogadorDto> getJogadorIdade(@PathVariable(value = "id") Integer id){
		
		JogadorTime jt = jTimeRep.udfJogadorIdade(id);
		
		JogadorDto dto = converterJogadorTime(jt);
		
		return ResponseEntity.ok().body(dto);
	}

	private JogadorDto converterJogadorTime(JogadorTime j) {

		JogadorDto dto = new JogadorDto();
		dto.setCodigo(j.getCodigo());
		dto.setNomeJogador(j.getNome());
		dto.setSexo(j.getSexo());
		dto.setAltura(j.getAltura());
		dto.setDt_nasc(j.getDt_nasc());
		dto.setIdade(j.getIdade());
		
		TimesDto tDto = new TimesDto();
		tDto.setId(j.getId());
		tDto.setNome(j.getNome());
		tDto.setCidade(j.getCidade());
		
		dto.setTimes(tDto);		
		
		return dto;
	}
}
