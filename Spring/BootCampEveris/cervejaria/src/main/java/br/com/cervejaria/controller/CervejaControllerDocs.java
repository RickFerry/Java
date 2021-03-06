package br.com.cervejaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import br.com.cervejaria.dto.CervejaDTO;
import br.com.cervejaria.exception.CervejaAlreadyRegisteredException;
import br.com.cervejaria.exception.CervejaNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Manages beer stock")
public interface CervejaControllerDocs {

	@ApiOperation(value = "Beer creation operation")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Success beer creation"),
			@ApiResponse(code = 400, message = "Missing required fields or wrong field range value.") })
	CervejaDTO createBeer(CervejaDTO beerDTO) throws CervejaAlreadyRegisteredException;

	@ApiOperation(value = "Returns beer found by a given name")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success beer found in the system"),
			@ApiResponse(code = 404, message = "Beer with given name not found.") })
	CervejaDTO findByName(@PathVariable String name) throws CervejaNotFoundException;

	@ApiOperation(value = "Returns a list of all beers registered in the system")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "List of all beers registered in the system"), })
	List<CervejaDTO> listBeers();

	@ApiOperation(value = "Delete a beer found by a given valid Id")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Success beer deleted in the system"),
			@ApiResponse(code = 404, message = "Beer with given id not found.") })
	void deleteById(@PathVariable Long id) throws CervejaNotFoundException;
}
