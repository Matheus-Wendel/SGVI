package com.fatec.mogi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fatec.mogi.util.Util;

@Entity
public class Compra implements BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Boolean tipoCompraBonus;

	@Column
	@DateTimeFormat(pattern = Util.FORMATO_DATA)
	@Temporal(TemporalType.DATE)
	private Date dataCompra;
	@ManyToOne
	private Setor setor;

	@ManyToOne
	private Cliente cliente;
	@Column
	private Integer quantidadeIngressos;
	@Column
	private String numeroCartao;
	@Column
	private String cvvCartao;
	@Column
	private String nomeTitularCartao;
	@Column
	@DateTimeFormat(pattern = Util.FORMATO_DATA_VALIDADE_CARTAO)
	@Temporal(TemporalType.DATE)
	private Date dataValidadeCartao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getTipoCompraBonus() {
		return tipoCompraBonus;
	}

	public void setTipoCompraBonus(Boolean tipoCompraBonus) {
		this.tipoCompraBonus = tipoCompraBonus;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Integer getQuantidadeIngressos() {
		return quantidadeIngressos;
	}

	public void setQuantidadeIngressos(Integer quantidadeIngressos) {
		this.quantidadeIngressos = quantidadeIngressos;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getCvvCartao() {
		return cvvCartao;
	}

	public void setCvvCartao(String cvvCartao) {
		this.cvvCartao = cvvCartao;
	}

	public String getNomeTitularCartao() {
		return nomeTitularCartao;
	}

	public void setNomeTitularCartao(String nomeTitularCartao) {
		this.nomeTitularCartao = nomeTitularCartao;
	}

	public Date getDataValidadeCartao() {
		return dataValidadeCartao;
	}

	public void setDataValidadeCartao(Date dataValidadeCartao) {
		this.dataValidadeCartao = dataValidadeCartao;
	}

}
