package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Customizacao;
import com.fatec.mogi.repository.CustomizacaoRepository;
@Service
public class CustomizacaoDAO implements IDAO {

	@Autowired
	CustomizacaoRepository customizacaoRepository;

	@Override
	@Transactional
	public BaseModel save(BaseModel baseModel) {
		Customizacao customizacao = (Customizacao) baseModel;

		return customizacaoRepository.save(customizacao);
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
