package com.fatec.mogi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Cliente extends Pessoa {

	@Column
	private Integer ingressoBonus;

	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	public Integer getIngressoBonus() {
		return ingressoBonus;
	}

	public void setIngressoBonus(Integer ingressoBonus) {
		this.ingressoBonus = ingressoBonus;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [ingressoBonus=" + ingressoBonus + ", endereco=" + endereco + ", getNome()=" + getNome()
				+ ", getCpf()=" + getCpf() + ", getDataNascimento()=" + getDataNascimento() + ", getTelefone()="
				+ getTelefone() + ", getUsuario()=" + getUsuario() + "]";
	}



	
}
