package br.com.ferry.catalogoproduto.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferry.catalogoproduto.model.Produto;
import br.com.ferry.catalogoproduto.repository.ProdutoRepository;

@Transactional
@RestController
@RequestMapping("/produto")
public class ProdutoController {

	private ProdutoRepository repository;

	public ProdutoController(ProdutoRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public Produto create(@RequestBody @Valid Produto produto) {
		return repository.save(produto);
	}

	@GetMapping
	public List<Produto> list() {
		return repository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Produto> findById(@PathVariable Long id) {
		return repository.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<Produto> findByName(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
}
