package com.fatec.mogi.strategy;

import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;
import com.fatec.mogi.model.Permissao;
import com.fatec.mogi.model.Usuario;

@Service
public class ClienteStrategy implements IStrategy {

	@Override
	public String processar(BaseModel baseModel) {
		String definicao = "";
		Cliente cliente = (Cliente) baseModel;

		Usuario usuario = cliente.getUsuario();

		usuario.setPermissao(Permissao.USUARIO);
		if (cliente.getIngressoBonus() == null)
			cliente.setIngressoBonus(0);

		return definicao;
	}
}