package br.com.hamburgueria.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hamburgueria.model.Hamburguer;

public class HamburguerDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nome;
	private LocalDate validade;
	private BigDecimal preco;

	public HamburguerDto(Hamburguer ham) {
		this.nome = ham.getNome();
		this.validade = ham.getValidade();
		this.preco = ham.getPreco();
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public static List<HamburguerDto> converter(List<Hamburguer> hamburgeres) {
		return hamburgeres.stream().map(HamburguerDto::new).collect(Collectors.toList());
	}
}