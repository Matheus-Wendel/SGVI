package com.fatec.mogi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Setor implements BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String descricao;
	@Column
	private Float valor;
//	
	@Column
	private Integer ingresosDisponiveis;
	

	public Setor() {
	super();
}

	public Setor(String descricao, Float valor, Integer ingresosDisponiveis) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.ingresosDisponiveis = ingresosDisponiveis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getIngresosDisponiveis() {
		return ingresosDisponiveis;
	}

	public void setIngresosDisponiveis(Integer ingresosDisponiveis) {
		this.ingresosDisponiveis = ingresosDisponiveis;
	}

	

	

}
