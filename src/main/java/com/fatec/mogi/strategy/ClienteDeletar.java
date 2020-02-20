package com.fatec.mogi.strategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.fatec.mogi.DAO.ClienteDAO;
import com.fatec.mogi.DAO.UsuarioDAO;
import com.fatec.mogi.model.BaseModel;

public class ClienteDeletar implements IStrategy {
	@Autowired
	ClienteDAO clienteDAO;

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Override
	public String processar(BaseModel baseModel) {
		
		
		
		return null;
	}
	
	
	
	
	

}
