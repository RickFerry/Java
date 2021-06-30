package br.com.ferry.controle.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.envers.Audited;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@Audited
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

	@Id
	private Long id;

	@NotEmpty
	private String descricao;

	@NotEmpty
	private String cnpj;

	@NotEmpty
	private String endereco;

	@NotEmpty
	private String bairo;

	@NotEmpty
	private String cidade;

	@NotEmpty
	private String estado;

	@NotEmpty
	private String telefone;
}
