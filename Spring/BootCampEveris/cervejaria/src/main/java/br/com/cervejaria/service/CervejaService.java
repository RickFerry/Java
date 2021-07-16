package br.com.cervejaria.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cervejaria.dto.CervejaDTO;
import br.com.cervejaria.entity.Cerveja;
import br.com.cervejaria.exception.CervejaAlreadyRegisteredException;
import br.com.cervejaria.exception.CervejaNotFoundException;
import br.com.cervejaria.exception.CervejaStockExceededException;
import br.com.cervejaria.mapper.CervejaMapper;
import br.com.cervejaria.repository.CervejaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaService {

	private final CervejaRepository beerRepository;
	private final CervejaMapper beerMapper = CervejaMapper.INSTANCE;

	public CervejaDTO createBeer(CervejaDTO beerDTO) throws CervejaAlreadyRegisteredException {
		verifyIfIsAlreadyRegistered(beerDTO.getNome());
		Cerveja beer = beerMapper.toModel(beerDTO);
		Cerveja savedBeer = beerRepository.save(beer);
		return beerMapper.toDTO(savedBeer);
	}

	public CervejaDTO findByName(String name) throws CervejaNotFoundException {
		Cerveja foundBeer = beerRepository.findByName(name).orElseThrow(() -> new CervejaNotFoundException(name));
		return beerMapper.toDTO(foundBeer);
	}

	public List<CervejaDTO> listAll() {
		return beerRepository.findAll().stream().map(beerMapper::toDTO).collect(Collectors.toList());
	}

	public void deleteById(Long id) throws CervejaNotFoundException {
		verifyIfExists(id);
		beerRepository.deleteById(id);
	}

	@SuppressWarnings("unused")
	private void verifyIfIsAlreadyRegistered(String name) throws CervejaAlreadyRegisteredException {
		Optional<Cerveja> optSavedBeer = beerRepository.findByName(name);
		if (optSavedBeer.isPresent()) {
			throw new CervejaAlreadyRegisteredException(name);
		}
	}

	private Cerveja verifyIfExists(Long id) throws CervejaNotFoundException {
		return beerRepository.findById(id).orElseThrow(() -> new CervejaNotFoundException(id));
	}

	public CervejaDTO increment(Long id, int quantityToIncrement)
			throws CervejaNotFoundException, CervejaStockExceededException {
		Cerveja beerToIncrementStock = verifyIfExists(id);
		int quantityAfterIncrement = quantityToIncrement + beerToIncrementStock.getQuantidade();
		if (quantityAfterIncrement <= beerToIncrementStock.getMax()) {
			beerToIncrementStock.setQuantidade(beerToIncrementStock.getQuantidade() + quantityToIncrement);
			Cerveja incrementedBeerStock = beerRepository.save(beerToIncrementStock);
			return beerMapper.toDTO(incrementedBeerStock);
		}
		throw new CervejaStockExceededException(id, quantityToIncrement);
	}
}
