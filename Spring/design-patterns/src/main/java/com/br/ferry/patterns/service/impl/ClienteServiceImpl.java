package com.br.ferry.patterns.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.ferry.patterns.model.Address;
import com.br.ferry.patterns.model.AddressRepository;
import com.br.ferry.patterns.model.Client;
import com.br.ferry.patterns.model.ClientRepository;
import com.br.ferry.patterns.service.ClienteService;
import com.br.ferry.patterns.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClientRepository clienteRepository;
	@Autowired
	private AddressRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	@Override
	public Iterable<Client> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Client buscarPorId(Long id) {
		Optional<Client> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Client cliente) {
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Client cliente) {
		Optional<Client> clienteBd = clienteRepository.findById(id);
		if (clienteBd.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

	private void salvarClienteComCep(Client cliente) {
		String cep = cliente.getEndereco().getCep();
		Address endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			Address novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
