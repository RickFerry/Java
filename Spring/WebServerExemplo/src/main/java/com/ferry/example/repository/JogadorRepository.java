package com.ferry.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferry.example.entities.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Integer>{

	List<Jogador> findJogadoresDataConv();
	
	Jogador findJogadorDataConv(Integer cod);
}
