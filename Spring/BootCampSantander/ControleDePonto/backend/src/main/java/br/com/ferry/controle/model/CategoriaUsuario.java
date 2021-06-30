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
public class CategoriaUsuario {

	@Id
	private long id;

	@NotEmpty
	private String desscricao;
}
