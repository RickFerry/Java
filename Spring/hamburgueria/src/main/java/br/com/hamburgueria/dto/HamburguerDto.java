package br.com.hamburgueria.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.hamburgueria.model.Hamburguer;

public class HamburguerDto {

	private String nome;
	private LocalDate validade;
	private Float preco;

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

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public static List<HamburguerDto> converter(List<Hamburguer> hamburgeres) {
		return hamburgeres.stream().map(HamburguerDto::new).collect(Collectors.toList());
	}
}