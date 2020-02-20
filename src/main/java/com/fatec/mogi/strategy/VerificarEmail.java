package com.fatec.mogi.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.ClienteDAO;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;
import com.fatec.mogi.repository.ClienteRepository;

@Service
public class VerificarEmail implements IStrategy {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ClienteDAO consulta;
	
	@Override
	public String processar(BaseModel baseModel) {
		String tipoUser = "";
		String unicidade = "";
		
		//tipoUser = baseModel.getClass().getSimpleName().toLowerCase();
		List<Cliente> pessoasConsulta;//isso vai ficar no if e vai ter a list<administrador>
		
//		if(tipoUser.equals("cliente"))
//		{
//			Cliente pessoa = (Cliente) baseModel;
//			IDAO daoGenerico = new ClienteDAO();
//		}
//		else
//		{
//			Administrador pessoa = (Administrador) baseModel;
//			IDAO daoGenerico = new AdministradorDAO();
//		}
		
		/* Isso aqui é por enquanto, tem que fazer o find all do Administrador e definir lá no
		 * repositorio do administrador 
		*/
		
		Cliente pessoa = (Cliente) baseModel;
		pessoasConsulta = consulta.findAll();
		
		for(Cliente pes : pessoasConsulta)
		{
			if(pes.getUsuario().getEmail().equals(pessoa.getUsuario().getEmail()))
			{	
				unicidade = "Email já utilizado!";
				break;
			}
		}
		return unicidade;
	}
}