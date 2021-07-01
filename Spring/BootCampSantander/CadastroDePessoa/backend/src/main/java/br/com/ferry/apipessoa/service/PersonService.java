package br.com.ferry.apipessoa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ferry.apipessoa.dto.request.PersonDTO;
import br.com.ferry.apipessoa.entity.Person;
import br.com.ferry.apipessoa.exception.PersonNotFoundException;
import br.com.ferry.apipessoa.mapper.PersonMapper;
import br.com.ferry.apipessoa.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Service
@Builder
@AllArgsConstructor
public class PersonService {

	private PersonRepository personRepository;
	private final PersonMapper personMapper = PersonMapper.INSTANCE;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public ResponseEntity<String> createPerson(PersonDTO personDTO) {
		Person personToSave = personMapper.toModel(personDTO);
		personRepository.save(personToSave);
		return ResponseEntity.ok("Sucesso!!!");
	}

	public List<PersonDTO> listAll() {
		List<Person> allPeople = personRepository.findAll();
		return allPeople.stream().map(personMapper::toDTO).collect(Collectors.toList());
	}

	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);

		return personMapper.toDTO(person);
	}

	public void delete(Long id) throws PersonNotFoundException {
		verifyIfExists(id);
		personRepository.deleteById(id);
	}

	public ResponseEntity<String> updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		verifyIfExists(id);

		Person personToUpdate = personMapper.toModel(personDTO);
		personRepository.save(personToUpdate);
		return ResponseEntity.ok("Sucesso!!!");
	}

	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
	}
}
