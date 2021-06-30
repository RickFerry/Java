package br.com.ferry.controle.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class Usuario {

	@Id
	private Long id;

	@ManyToOne
	private CategoriaUsuario categoriaUsuario;

	@NotEmpty
	private String nome;

	@ManyToOne
	private Empresa empresa;

	@ManyToOne
	private NivelAcesso nivelAcesso;

	@ManyToOne
	private JornadaTrabalho jornadaTrabalho;

	@NotEmpty
	private BigDecimal tolerancia;

	@NotEmpty
	private LocalDateTime inicioJornada;

	@NotEmpty
	private LocalDateTime finalJornada;
}
