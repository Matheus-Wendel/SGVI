package com.fatec.mogi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Artista implements BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Size(min=1)
	@Column(nullable = false)
	private String nome;
	@Size(min=1)
	@Column(nullable = false)
	private String descricao;
	@Size(min=1)
	@Column(nullable = false)
	private String genero;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

}
