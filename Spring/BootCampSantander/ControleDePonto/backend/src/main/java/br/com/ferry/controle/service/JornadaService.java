package br.com.ferry.controle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ferry.controle.model.JornadaTrabalho;
import br.com.ferry.controle.repository.JornadaRepository;

@Service
public class JornadaService {

	private JornadaRepository jornadaRepository;

	public JornadaService(JornadaRepository jornadaRepository) {
		this.jornadaRepository = jornadaRepository;
	}

	public JornadaTrabalho saveJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);

	}

	public List<JornadaTrabalho> findAll() {
		return jornadaRepository.findAll();
	}

	public Optional<JornadaTrabalho> getById(Long idJornada) {
		return jornadaRepository.findById(idJornada);
	}

	public JornadaTrabalho updateJornada(JornadaTrabalho jornadaTrabalho) {
		return jornadaRepository.save(jornadaTrabalho);

	}

	public void deleteJornada(Long idJornada) {
		jornadaRepository.deleteById(idJornada);
	}
}
