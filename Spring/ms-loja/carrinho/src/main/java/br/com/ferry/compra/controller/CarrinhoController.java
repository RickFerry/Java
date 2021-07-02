package br.com.ferry.compra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferry.compra.model.Carrinho;
import br.com.ferry.compra.model.Item;
import br.com.ferry.compra.repository.CarrinhoRepository;

@Transactional
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	private CarrinhoRepository repository;

	public CarrinhoController(CarrinhoRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<Carrinho> addItem(@RequestBody Item item, Carrinho carrinho) {
		List<Item> list = new ArrayList<Item>();
		list.add(item);
		carrinho.setItens(list);
		return ResponseEntity.ok(repository.save(carrinho));
	}

	@GetMapping("/{id}")
	public Optional<Carrinho> findById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@DeleteMapping("/{id}")
	public void clear(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
