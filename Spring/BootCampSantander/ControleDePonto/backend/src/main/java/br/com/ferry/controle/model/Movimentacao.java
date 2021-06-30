package br.com.ferry.controle.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Movimentacao {

	@Data
	@Embeddable
	public class MovimentacaoId implements Serializable {
		private static final long serialVersionUID = 1L;

		@NotEmpty
		private long idMovimento;

		@NotEmpty
		private long idUsuario;
	}

	@Id
	@EmbeddedId
	private MovimentacaoId movimentacaoId;

	@NotEmpty
	private LocalDateTime dataEntrada;

	@NotEmpty
	private LocalDateTime dataSaida;

	@NotEmpty
	private BigDecimal periodo;

	@ManyToOne
	private Ocorrencia ocorrencia;

	@ManyToOne
	private Calendario calendario;
}
