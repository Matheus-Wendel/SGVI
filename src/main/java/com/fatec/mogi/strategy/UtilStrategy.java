package com.fatec.mogi.strategy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilStrategy {
	
	
	@Autowired
	ClienteStrategy clienteStrategy;
	@Autowired
	EncriptarSenha encriptarSenha;
	@Autowired
	ValidaCPF validaCPF;
	@Autowired
	VerificarCpf verificarCpf;
	@Autowired
	VerificarEmail verificarEmail;
	
	@Autowired
	CompraStrategy compraStrategy;
	
	@Autowired
	AdministradorStrategy administradorStrategy;

	public List<IStrategy> montaListaStrategy(String classe) {
		List<IStrategy> listaRetorno = new ArrayList<IStrategy>();

		switch (classe) {
		case "clienteSALVAR":
			listaRetorno.add(clienteStrategy);
			listaRetorno.add(encriptarSenha);
			listaRetorno.add(validaCPF);
			listaRetorno.add(verificarCpf);
			listaRetorno.add(verificarEmail);

			return listaRetorno;
		case "clienteATUALIZAR":
			listaRetorno.add(clienteStrategy);
			
			return listaRetorno;
			
		case "compraSALVAR":
			listaRetorno.add(compraStrategy);
			return listaRetorno;
		case "administradorSALVAR":
			listaRetorno.add(administradorStrategy);
			listaRetorno.add(validaCPF);
			listaRetorno.add(encriptarSenha);
			return listaRetorno;
		default:
			return null;
		}

	}

}
