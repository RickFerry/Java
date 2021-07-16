package br.com.cervejaria.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cervejaria.dto.CervejaDTO;
import br.com.cervejaria.dto.QuantidadeDTO;
import br.com.cervejaria.exception.CervejaAlreadyRegisteredException;
import br.com.cervejaria.exception.CervejaNotFoundException;
import br.com.cervejaria.exception.CervejaStockExceededException;
import br.com.cervejaria.service.CervejaService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/beers")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CervejaController implements CervejaControllerDocs {

	private final CervejaService cervejaService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CervejaDTO createBeer(@RequestBody @Valid CervejaDTO beerDTO) throws CervejaAlreadyRegisteredException {
		return cervejaService.createBeer(beerDTO);
	}

	@GetMapping("/{name}")
	public CervejaDTO findByName(@PathVariable String name) throws CervejaNotFoundException {
		return cervejaService.findByName(name);
	}

	@GetMapping
	public List<CervejaDTO> listBeers() {
		return cervejaService.listAll();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws CervejaNotFoundException {
		cervejaService.deleteById(id);
	}

	@PatchMapping("/{id}/increment")
	public CervejaDTO increment(@PathVariable Long id, @RequestBody @Valid QuantidadeDTO quantityDTO)
			throws CervejaNotFoundException, CervejaStockExceededException {
		return cervejaService.increment(id, quantityDTO.getQuantidade());
	}
}
