package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Administrador;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;
import com.fatec.mogi.model.Usuario;
import com.fatec.mogi.security.usuarioUtil;

@Service
public class EncriptarSenha implements IStrategy {

	@Override
	public String processar(BaseModel baseModel) {

		Usuario usuario = null;

		if(baseModel instanceof Cliente) {
			Cliente cliente = (Cliente) baseModel;
			 usuario = cliente.getUsuario();
			
		}
		if(baseModel instanceof Administrador) {
			Administrador administrador = (Administrador) baseModel;
			 usuario = administrador.getUsuario();
		}
		String encriptar = "";


		usuario.setSenha(usuarioUtil.encriptaSenha(usuario.getSenha()));


		return encriptar;
	}
}