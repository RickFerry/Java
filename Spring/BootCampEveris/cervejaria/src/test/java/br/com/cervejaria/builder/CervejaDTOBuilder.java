package br.com.cervejaria.builder;

import br.com.cervejaria.dto.CervejaDTO;
import br.com.cervejaria.enums.TipoCerveja;
import lombok.Builder;

@Builder
public class CervejaDTOBuilder {

	@Builder.Default
	private Long id = 1L;

	@Builder.Default
	private String nome = "Brahma";

	@Builder.Default
	private String marca = "Ambev";

	@Builder.Default
	private int maximo = 50;

	@Builder.Default
	private int quantidade = 10;

	@Builder.Default
	private TipoCerveja tipo = TipoCerveja.LAGER;

	public CervejaDTO toBeerDTO() {
		return new CervejaDTO(id, nome, marca, maximo, quantidade, tipo);
	}
}
