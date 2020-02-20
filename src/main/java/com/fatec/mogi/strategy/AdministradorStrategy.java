package com.fatec.mogi.strategy;

import com.fatec.mogi.model.BaseModel;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Administrador;
import com.fatec.mogi.model.Permissao;
import com.fatec.mogi.model.Usuario;
@Service
public class AdministradorStrategy implements IStrategy {

	@Override
	public String processar(BaseModel baseModel) {
		Administrador administrador = (Administrador) baseModel;

		Usuario usuario = administrador.getUsuario();

		usuario.setPermissao(Permissao.ADMINISTRADOR);

		return "";
	}

}
