package br.com.ferry.apipessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.apipessoa.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
