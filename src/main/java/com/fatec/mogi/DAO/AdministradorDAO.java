package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.Administrador;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.repository.AdministradorRepository;
/*import com.fatec.mogi.repository.AdministradorRepository;*/

@Service
public class AdministradorDAO implements IDAO {
	
	
	  @Autowired 
	  AdministradorRepository administradorRepository;
	 
	
	@Override
	public BaseModel save(BaseModel baseModel) {
		Administrador administrador = (Administrador) baseModel;
		return administradorRepository.save(administrador);
	}

	@Override
	public String delete(Long id) {

		administradorRepository.deleteById(id);
		return null;
	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		
		if(administradorRepository.existsById(id)) {
			Administrador administrador = (Administrador) baseModel;
			administrador.setId(id);
			return save(administrador);
			
			
		}
		return null;
		
	}

	@Override
	public List<Administrador> findAll() {
		 return administradorRepository.findAll(); 
	}

	@Override
	public Optional<Administrador> findById(Long id) {
		 return administradorRepository.findById(id); 
	}

	@Override
	public List<Administrador> findByParameter(String parametro) {
		return administradorRepository.findByNome(parametro);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
