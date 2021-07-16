package br.com.cervejaria.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.com.cervejaria.dto.CervejaDTO;
import br.com.cervejaria.entity.Cerveja;

@Mapper
public interface CervejaMapper {

	CervejaMapper INSTANCE = Mappers.getMapper(CervejaMapper.class);

	Cerveja toModel(CervejaDTO beerDTO);

	CervejaDTO toDTO(Cerveja beer);
}
