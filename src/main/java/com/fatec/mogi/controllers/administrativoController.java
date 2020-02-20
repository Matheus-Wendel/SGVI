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
import org.springframework.web.servlet.ModelAndView;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.Administrador;
import com.fatec.mogi.model.Artista;
import com.fatec.mogi.model.BaseModel;

@Controller
@RequestMapping("/administrativo")

public class administrativoController {

	@Autowired
	Facade fachada;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView administrativo() {

		ModelAndView mv = new ModelAndView("/administrativo/administrativo");
				mv.addObject("artistas",fachada.BuscarTodos(new Artista()));

		return mv;

	}

	@PostMapping("/administrador/cadastro")
	public @ResponseBody BaseModel cadastroAdministrador(Administrador administrador) {

//		return administrador;
		return fachada.salvar(administrador);

	}
	
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/administrador/getAllAdministradors")
	@ResponseBody
	public List<Administrador> buscaTodosAdministrador(Administrador arista) {

		return (List<Administrador>)(List<?>)fachada.BuscarTodos(arista);

	}

	@SuppressWarnings("unchecked")
	@GetMapping("/administrador/getAdministradors/{nomeAdministrador}")
	@ResponseBody
	public List<Administrador> buscaTodosAdministradorPorNome(Administrador administrador, @PathVariable String nomeAdministrador) {

		if (nomeAdministrador.equals("todos")) {
			return (List<Administrador>)(List<?>) fachada.BuscarTodos(administrador);
		} else {
			return(List<Administrador>)(List<?>) fachada.BuscarPorParmetro(administrador, nomeAdministrador);
		}
	}

	@PostMapping("/administrador/deletarAdministrador/{id}")
	@ResponseBody
	public String removerAdministrador(Administrador administrador, @PathVariable Long id) {
		fachada.deletar(administrador, id);

		return null;

	}
	
	@PostMapping("/administrador/atualizarAdministrador/{id}")
	@ResponseBody 
	public String atualizarAdministrador(Administrador administrador, @PathVariable Long id) {
		
		fachada.atualizar(administrador, id);

		return null;

	}
	@PostMapping("/administrador/buscaAdministradorId/{id}")
	@ResponseBody 
	public Administrador buscaAdministradorId(Administrador administrador, @PathVariable Long id) {
		
		return (Administrador) fachada.BuscarPorId(administrador, id).get();
		
		
		
	}

}
