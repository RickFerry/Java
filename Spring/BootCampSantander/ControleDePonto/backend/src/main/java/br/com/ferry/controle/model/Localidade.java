package br.com.ferry.controle.model;

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
public class Localidade {

	@Id
	private long id;

	@ManyToOne
	private NivelAcesso nivelAcesso;

	@NotEmpty
	private String descricao;
}
