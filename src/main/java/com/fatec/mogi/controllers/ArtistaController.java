package com.fatec.mogi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.Artista;

@Controller
public class ArtistaController {
	@Autowired
	Facade fachada;
	

	@RequestMapping(value = "/administrativo/artista/cadastro", method = RequestMethod.POST)
	public @ResponseBody void cadastroArtista(Artista artista) {

		fachada.salvar(artista);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/administrativo/artista/getAllArtistas")
	@ResponseBody
	public List<Artista> buscaTodosArtisas(Artista arista) {

		return (List<Artista>) (List<?>) fachada.BuscarTodos(arista);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/administrativo/artista/getArtistas/{nomeArtista}")
	@ResponseBody
	public List<Artista> buscaTodosArtisasPorNome(Artista artista, @PathVariable String nomeArtista) {

		if (nomeArtista.equals("todos")) {
			return (List<Artista>) (List<?>) fachada.BuscarTodos(artista);
		} else {
			return (List<Artista>) (List<?>) fachada.BuscarPorParmetro(artista, nomeArtista);
		}
	}

	@PostMapping("/administrativo/artista/deletarArtista/{id}")
	@ResponseBody
	public String removerArtista(Artista artista, @PathVariable Long id) {
		
		
		return fachada.deletar(artista, id);


	}

	@PostMapping("/administrativo/artista/atualizarArtista/{id}")
	@ResponseBody
	public String atualizarArtista(Artista artista, @PathVariable Long id) {

		fachada.atualizar(artista, id);

		return null;

	}
	@PostMapping("/administrativo/artista/buscaArtistaId/{id}")
	@ResponseBody
	public Artista buscaArtistaPorID(Artista artista, @PathVariable Long id) {
		
		return (Artista) fachada.BuscarPorId(artista, id).get();
		
		
		
	}

}
