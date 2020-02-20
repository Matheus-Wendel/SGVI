
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
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Compra;
import com.fatec.mogi.model.Evento;
import com.fatec.mogi.security.usuarioUtil;

@Controller
public class CompraController extends usuarioUtil {
	@Autowired
	Facade fachada;

	@RequestMapping(value = "/compra/{idEvento}", method = RequestMethod.GET)
	public ModelAndView compra(@PathVariable Long idEvento) {
		// clienteGetPorUsuario(getUsuarioLogado());
		ModelAndView mv = new ModelAndView("/compra/compra");
		mv.addObject("evento", (Evento) fachada.BuscarPorId(new Evento(), idEvento).get());
		return mv;
	}

	@PostMapping("/usuario/salvaCompra")
	@ResponseBody
	public BaseModel salvaCompra(Compra compra) {

		return fachada.salvar(compra);
//		return compra;

	}
	@SuppressWarnings("unchecked")
	@PostMapping("/usuario/getAllCompras")
	@ResponseBody
	public List<Compra> buscaCompra(Compra compra) {
		
		return (List<Compra>)(List<?>)fachada.BuscarPorParmetro(compra, usuarioUtil.getUsuario());
		
	}
}
