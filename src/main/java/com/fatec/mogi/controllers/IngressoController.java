package com.fatec.mogi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.Ingresso;
import com.fatec.mogi.security.usuarioUtil;

@Controller
public class IngressoController {

	@Autowired
	Facade fachada;

	@SuppressWarnings("unchecked")
	@PostMapping("/usuario/getAllIngressos")
	@ResponseBody
	public List<Ingresso> buscaCompra(Ingresso ingresso) {
		
		return (List<Ingresso>)(List<?>)fachada.BuscarPorParmetro(ingresso, usuarioUtil.getUsuario());
		
	}
}
