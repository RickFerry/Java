package br.com.hamburgueria.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.hamburgueria.model.Hamburguer;

public class UpdateForm {

	@NotNull
	@NotEmpty
	private String nome;
	
	@NotNull
	@NotEmpty
	private LocalDate validade;
	
	@NotNull
	@NotEmpty
	private Float preco;

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

	public Hamburguer atualiza(Hamburguer hamburguer) {
		hamburguer.setNome(this.nome);
		hamburguer.setValidade(this.validade);
		hamburguer.setPreco(this.preco);
		
		return hamburguer;
	}
}