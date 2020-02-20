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
public class Ingresso implements BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private Boolean tipoCompraBonus;
	@Column
	private Boolean contagemParaBonus;
	@ManyToOne
	private Setor setor;
	@ManyToOne
	private Compra compra;
	
	@DateTimeFormat(pattern = Util.FORMATO_DATA)
	@Temporal(TemporalType.DATE)
	//TODO mudar para tipo data 
	private Date dataCompra;
	
	@ManyToOne
	private Cliente cliente;

	
	
	public Ingresso() {
		super();
	}



	public Ingresso(Compra compra) {
		super();
		this.tipoCompraBonus = compra.getTipoCompraBonus();
		this.contagemParaBonus = compra.getTipoCompraBonus();
		this.setor = compra.getSetor();
		this.compra = compra;
		this.dataCompra = compra.getDataCompra();
		this.cliente = compra.getCliente();
	}



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

	public Boolean getContagemParaBonus() {
		return contagemParaBonus;
	}

	public void setContagemParaBonus(Boolean contagemParaBonus) {
		this.contagemParaBonus = contagemParaBonus;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", tipoCompraBonus=" + tipoCompraBonus + ", contagemParaBonus="
				+ contagemParaBonus + ", setor=" + setor.getId() + ", compra=" + compra.getId() + ", dataCompra=" + dataCompra
				+ ", cliente=" + cliente.getId() + "]";
	}

	

	
	
}
