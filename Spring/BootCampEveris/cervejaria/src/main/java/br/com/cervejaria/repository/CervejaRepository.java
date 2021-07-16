package br.com.cervejaria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cervejaria.entity.Cerveja;

public interface CervejaRepository extends JpaRepository<Cerveja, Long> {
	Optional<Cerveja> findByName(String name);
}
