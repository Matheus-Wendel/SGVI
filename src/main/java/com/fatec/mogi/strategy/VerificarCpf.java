package com.fatec.mogi.strategy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.ClienteDAO;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cliente;

@Service
public class VerificarCpf implements IStrategy {
	
	@Autowired
	ClienteDAO consulta;
	
	@Override
	public String processar(BaseModel baseModel) {
		
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
			if(pes.getCpf().equals(pessoa.getCpf()))
			{	
				unicidade = "CPF já utilizado!";
				break;
			}
		}
		return unicidade;
	}
}