package com.fatec.mogi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.Cidade;
import com.fatec.mogi.model.Estado;

@Controller
public class EnderecoController {

	@Autowired
	Facade fachada;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping("/livre/getAllEstados")
	@ResponseBody
	public List<Estado> getEstados(Estado estado) {

		return (List<Estado>)(List<?>)fachada.BuscarTodos(estado);

	}
	@SuppressWarnings("unchecked")
	@PostMapping("/livre/getCidade/{idEstado}")
	@ResponseBody
	public List<Cidade> getCidades(Cidade cidade,@PathVariable Long idEstado) {
		return (List<Cidade>)(List<?>)fachada.BuscarPorParmetro(cidade, idEstado.toString());
		
	}
	
}
