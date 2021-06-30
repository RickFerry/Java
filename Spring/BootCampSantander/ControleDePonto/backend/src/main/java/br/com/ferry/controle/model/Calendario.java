package br.com.ferry.controle.model;

import java.time.LocalDateTime;

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
public class Calendario {

	@Id
	private Long id;

	@ManyToOne
	private TipoData tipoData;

	@NotEmpty
	private String descricao;

	@NotEmpty
	private LocalDateTime dataEspecial;
}
