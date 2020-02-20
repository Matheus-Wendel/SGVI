package com.fatec.mogi.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

import com.fatec.mogi.util.Util;

@Entity
public class Evento implements BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nome;


	@Column
	@DateTimeFormat(pattern = Util.FORMATO_DATA_HORA)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaInicio;
	@Column
	@DateTimeFormat(pattern = Util.FORMATO_DATA_HORA)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horaTermino;
	@Column
	private String descricao;
	
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Customizacao customizacao;
	@OneToOne
	@Cascade(CascadeType.ALL)
	private Endereco endereco;
	@ManyToMany
	@Cascade(CascadeType.REFRESH)
	private List<Artista> artista;
	
	@OneToMany
	@Cascade(CascadeType.ALL)
	private List<Setor> setor;

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

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}	

	public Customizacao getCustomizacao() {
		return customizacao;
	}

	public void setCustomizacao(Customizacao customizacao) {
		this.customizacao = customizacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Artista> getArtista() {
		return artista;
	}

	public void setArtista(List<Artista> artista) {
		this.artista = artista;
	}

	public List<Setor> getSetor() {
		return setor;
	}

	public void setSetor(List<Setor> setor) {
		this.setor = setor;
	}

	
	

}
