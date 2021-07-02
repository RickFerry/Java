package br.com.ferry.catalogoproduto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.catalogoproduto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	List<Produto> findByNome(String nome);
}
