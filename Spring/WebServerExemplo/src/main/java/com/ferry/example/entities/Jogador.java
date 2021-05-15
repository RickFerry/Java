package com.ferry.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Jogador")
@NamedNativeQuery(
		name = "Jogador.findJogadoresDataConv",
		query = "SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+"CONVERT(CHAR(10), j.dt_nasc, 103) as dt_nasc, j.id_time,"
				+"t.id, t.nome, t.cidade"
				+"FROM jogador j, time"
				+"WHERE j.id = t.id",
		resultClass = Jogador.class
		)
@NamedNativeQuery(
		name = "Jogador.findJogadorDataConv",
		query = "	SELECT j.codigo, j.nomeJogador, j.sexo, j.altura,"
				+"CONVERT(CHAR(10), j.dt_nasc, 103) as dt_nasc, j.id_time,"
				+"t.id, t.nome, t.cidade"
				+"FROM jogador j, time"
				+"WHERE j.id = t.id"
				+"AND j.codigo = ?1",
		resultClass = Jogador.class
		)
public class Jogador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer codigo;
	
	@Column
	private String nomeJogador;
	
	@Column
	private String sexo;
	
	@Column
	private Float altura;
	
	@Column
	private String dt_nasc;
	
	@ManyToOne(targetEntity = Times.class)
	@JoinColumn(name = "id_time")
	private Times times;
	
	public Jogador() {}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nomeJogador;
	}
	public void setNome(String nome) {
		this.nomeJogador = nome;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Float getAltura() {
		return altura;
	}
	public void setAltura(Float altura) {
		this.altura = altura;
	}
	public String getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(String dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public Times getTimes() {
		return times;
	}
	public void setTimes(Times times) {
		this.times = times;
	}	
	@Override
	public String toString() {
		return "Jogador [codigo=" + codigo + ", nome=" + nomeJogador + ", sexo=" + sexo + ", altura=" + altura + ", dt_nasc="
				+ dt_nasc + ", times=" + times + "]";
	}
}