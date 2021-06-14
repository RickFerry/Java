package br.com.hamburgueria.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "Hamburguer")
public class Hamburguer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@NotBlank
	@Column(name = "Nome")
	private String nome;

	@NotNull
	@NotBlank
	@Column(name = "Validade")
	private LocalDate validade;

	@NotNull
	@NotBlank
	@Column(name = "Preco")
	private Float preco;

	public Hamburguer() {
	}

	public Hamburguer(String nome, LocalDate validade, Float preco) {
		this.nome = nome;
		this.validade = validade;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
}