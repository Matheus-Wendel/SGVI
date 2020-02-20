package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Estado;
import com.fatec.mogi.repository.EstadoRepository;
@Service
public class EstadoDAO implements IDAO {
	@Autowired
	EstadoRepository estadoRepository;

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
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Optional findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findByParameter(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
