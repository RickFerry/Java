package br.com.hamburgueria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.hamburgueria.dto.HamburguerDto;
import br.com.hamburgueria.form.HamburguerForm;
import br.com.hamburgueria.form.UpdateForm;
import br.com.hamburgueria.model.Hamburguer;
import br.com.hamburgueria.repositories.HamburguerRepository;

@Service
public class HamburguerService {

	@Autowired
	private HamburguerRepository repository;

	public List<HamburguerDto> pesquisar(String nome) {
		if (nome == null) {
			List<Hamburguer> hamburgueres = repository.findAll();
			return HamburguerDto.converter(hamburgueres);
		}
		List<Hamburguer> hamburgueres = repository.findByNome(nome);
		return HamburguerDto.converter(hamburgueres);
	}

	public void adicionar(HamburguerForm form) {
		Hamburguer hamburguer = form.converter();
		repository.save(hamburguer);
	}

	public ResponseEntity<HamburguerDto> atualiza(Long id, UpdateForm form) {
		Hamburguer hamburguer = repository.findById(id).get();
		Hamburguer h = form.atualiza(hamburguer);

		return ResponseEntity.ok(new HamburguerDto(h));
	}

	public ResponseEntity<?> remove(Long id) {
		repository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}
