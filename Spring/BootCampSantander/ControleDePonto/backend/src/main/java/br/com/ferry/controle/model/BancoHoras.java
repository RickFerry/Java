package br.com.ferry.controle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BancoHoras {

	@Data
	@Embeddable
	public class BancoHorasId implements Serializable {
		private static final long serialVersionUID = 1L;

		@NotEmpty
		private long idBancoHoras;

		@NotEmpty
		private long idMovimentacao;

		@NotEmpty
		private long idUsuario;

	}

	@EmbeddedId
	private BancoHorasId bancoHorasId;

	@NotEmpty
	private LocalDateTime dataTrabalhada;

	@NotEmpty
	private BigDecimal quantidadeHoras;

	@NotEmpty
	private BigDecimal saldoHoras;

}
