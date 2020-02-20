package com.fatec.mogi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Endereco implements BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column
	private String bairro;
	@Column
	private String cep;
	@Column
	private String rua;
	@Column
	private String numero;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	private Cidade cidade;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", bairro=" + bairro + ", cep=" + cep + ", rua=" + rua + ", numero=" + numero
				+ ", cidade=" + cidade + "]";
	}

	
}
