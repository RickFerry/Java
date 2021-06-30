package br.com.ferry.controle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
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
public class Ocorrencia {

	@Id
	private long id;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String descricao;
}
