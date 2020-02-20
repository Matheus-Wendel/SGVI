package com.fatec.mogi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fatec.mogi.facade.Facade;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;
import com.fatec.mogi.security.usuarioUtil;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	Facade fachada;

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public @ResponseBody BaseModel cadastroCliente(Cliente cliente) {
		// ClienteVH vh = new ClienteVH();
//		Cliente cliente= vh.montar(dadosEntidade);
		// commandSave.execute(cliente);
		return fachada.salvar(cliente);
		// clienteDAO.save(cliente);
		// System.out.println(usuario.getClass().getName());

	}

	@PostMapping("/usuario/atualizar")
	public @ResponseBody BaseModel atualizarDados(Cliente cliente, Long id) {
		return fachada.atualizar(cliente, id);
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/usuario/getCliente")
	@ResponseBody
	public List<Cliente> buscaCliente(Cliente cliente) {

		return (List<Cliente>) (List<?>) fachada.BuscarPorParmetro(cliente, usuarioUtil.getUsuario());

	}
}
