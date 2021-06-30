package br.com.ferry.controle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.controle.model.JornadaTrabalho;

public interface JornadaRepository extends JpaRepository<JornadaTrabalho, Long> {
}
