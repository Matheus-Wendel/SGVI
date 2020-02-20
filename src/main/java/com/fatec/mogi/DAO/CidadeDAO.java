package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Cidade;
import com.fatec.mogi.repository.CidadeRepository;
@Service
public class CidadeDAO implements IDAO {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@Override
	public BaseModel save(BaseModel baseModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseModel update(BaseModel baseModel, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> findByParameter(String parametro) {
		return cidadeRepository.FindCidadePorEstado(Long.parseLong(parametro));
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
