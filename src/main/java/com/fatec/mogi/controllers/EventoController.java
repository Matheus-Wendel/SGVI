package com.fatec.mogi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.Artista;
import com.fatec.mogi.model.Evento;
import com.fatec.mogi.util.EventoUtil;
@Controller
public class EventoController {
	
	@Autowired
	Facade fachada;

	@RequestMapping(value = "/administrativo/evento/cadastro", method = RequestMethod.POST )
	public @ResponseBody Evento cadastroEvento( Evento evento, @RequestParam("artista.id") List<Artista> artistas,
			@RequestParam("setor.descricao") List<String> descricoes,
			@RequestParam("setor.valor") List<Float> valores,
			@RequestParam("setor.ingresosDisponiveis") List<Integer> ingresosDisponiveis) {

		
		return (Evento) fachada.salvar(EventoUtil.montaEvento(evento, artistas, descricoes, valores, ingresosDisponiveis));

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/evento/getAllEventos")
	@ResponseBody
	public List<Evento> buscaTodosArtisas(Evento evento) {

		return (List<Evento>)(List<?>)fachada.BuscarTodos(evento);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/evento/getEventos/{nomeEvento}")
	@ResponseBody
	public List<Evento> buscaTodosArtisasPorNome(Evento evento, @PathVariable String nomeEvento) {

		if (nomeEvento.equals("todos")) {
			return (List<Evento>)(List<?>) fachada.BuscarTodos(evento);
		} else {
			return(List<Evento>)(List<?>) fachada.BuscarPorParmetro(evento, nomeEvento);
		}
	}
	
	@GetMapping("/evento/getEventoPorIdSetor/{idSetor}")
	@ResponseBody
	public Evento buscaEventoPorSetor(Evento evento,@PathVariable Long idSetor) {
		return (Evento) fachada.BuscarPorParmetro(evento, idSetor);
	}

	@PostMapping("/administrativo/evento/deletarEvento/{id}")
	@ResponseBody
	public String removerEvento(Evento evento, @PathVariable Long id) {
		fachada.deletar(evento, id);

		return null;

	}
	
	@PostMapping("/administrativo/evento/atualizarEvento/{id}")
	@ResponseBody 
	public String atualizarEvento(Evento evento, @PathVariable Long id,
			@RequestParam("artista.id") List<Artista> artistas,
			@RequestParam("setor.descricao") List<String> descricoes,
			@RequestParam("setor.valor") List<Float> valores,
			@RequestParam("setor.ingresosDisponiveis") List<Integer> ingresosDisponiveis) {
		
		fachada.atualizar(EventoUtil.montaEvento(evento, artistas, descricoes, valores, ingresosDisponiveis), id);

		return null;

	}
	@PostMapping("/administrativo/evento/buscaEventoId/{id}")
	@ResponseBody 
	public Evento buscaEventoId(Evento evento, @PathVariable Long id) {
		
		return (Evento) fachada.BuscarPorId(evento, id).get();
		
		
		
	}

}
