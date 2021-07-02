package br.com.ferry.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ferry.compra.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
