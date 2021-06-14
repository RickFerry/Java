package br.com.hamburgueria.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.hamburgueria.dto.HamburguerDto;
import br.com.hamburgueria.form.HamburguerForm;
import br.com.hamburgueria.form.UpdateForm;
import br.com.hamburgueria.service.HamburguerService;

@RestController
@Transactional
@RequestMapping("/hamburguer")
public class HamburguerController {

	@Autowired
	private HamburguerService service;

	@GetMapping("/lista")
	public List<HamburguerDto> pesquisar(Model model, String nome) {
		List<HamburguerDto> hamburgueres = service.pesquisar(nome);
		model.addAttribute("lista", hamburgueres);

		return hamburgueres;
	}

	@PostMapping("/cadastro")
	public void adicionar(@RequestBody @Valid HamburguerForm form) {
		service.adicionar(form);
	}

	@PutMapping("/{id}")
	public ResponseEntity<HamburguerDto> atualiza(@RequestBody @Valid @PathVariable Long id, UpdateForm form) {
		return service.atualiza(id, form);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remove(@PathVariable Long id) {
		return service.remove(id);
	}
}