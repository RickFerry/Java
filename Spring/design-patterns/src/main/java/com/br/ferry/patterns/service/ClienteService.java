package com.br.ferry.patterns.service;

import com.br.ferry.patterns.model.Client;

public interface ClienteService {

	Iterable<Client> buscarTodos();

	Client buscarPorId(Long id);

	void inserir(Client cliente);

	void atualizar(Long id, Client cliente);

	void deletar(Long id);

}
