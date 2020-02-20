package com.fatec.mogi.controllers;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping({"","/inicial"})
public class InicialController {

//	
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView inicial() {
		ModelAndView mv = new ModelAndView("inicial/index");
		return mv;
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil() {
		ModelAndView mv = new ModelAndView("inicial/perfil");
		return mv;
	}
	
	@RequestMapping(value = "/compras", method = RequestMethod.GET)
	public ModelAndView compras() {
		ModelAndView mv = new ModelAndView("inicial/compras");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("inicial/login");
		return mv;
	}
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastro() {
//		ModelAndView mv = new ModelAndView("inicial/login");
		ModelAndView mv = new ModelAndView("inicial/cadastro");
		return mv;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("inicial/home");
		return mv;
	}
	
	// TODO REMOVER ESSE METODO NA VERSAO FINAL
	@GetMapping("/senha/{senha}")
	@ResponseBody
	public String encriptaSenha(@PathVariable String senha) {
		//INSTANIA DE OBJETO QUE IRA ENCRIPTAR A SENHA
		// O TIPO DE ENCRIPTACAO EH BCryptPasswordEncoder
		
		BCryptPasswordEncoder encriptadorSenha = new BCryptPasswordEncoder();
		
		//RETORNA COMO RESPONSEBODY A SENHA DIGITADA NA URL JA ENCRIPTADA
		//FUNCAO ENCODE ENCRIPTA SENHAS
		return  encriptadorSenha.encode(senha);


	}

}
