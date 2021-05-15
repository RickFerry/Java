package com.ferry.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ferry.example.entities.JogadorTime;

public interface JogadorTimeRepository extends JpaRepository<JogadorTime, Integer>{

	JogadorTime udfJogadorIdade(Integer codigo);
}
