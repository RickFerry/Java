package br.com.hamburgueria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hamburgueria.model.Hamburguer;

public interface HamburguerRepository extends JpaRepository<Hamburguer, Long> {

	List<Hamburguer> findByNome(String nome);
}
