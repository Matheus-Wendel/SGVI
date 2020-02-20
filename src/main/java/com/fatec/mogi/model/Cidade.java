package com.fatec.mogi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Cidade implements BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column
	private String nome;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Estado estado;
	
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado + "]";
	}
	



}
