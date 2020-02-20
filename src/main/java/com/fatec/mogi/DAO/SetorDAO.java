package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Setor;
import com.fatec.mogi.repository.SetorRepository;
@Service
public class SetorDAO implements IDAO {

	@Autowired
	SetorRepository setorRepository;
	
	@Override
	public BaseModel save(BaseModel baseModel) {
		Setor setor =(Setor) baseModel;
		setorRepository.save(setor);
		
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
	public List<Setor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Setor> findById(Long id) {
		return setorRepository.findById(id);
	}

	@Override
	public List<Setor> findByParameter(String parametro) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void subtraiIngressos(Long id, int quantidadeIngressos) {
		Setor setor = setorRepository.findById(id).get();
		
		setor.setIngresosDisponiveis(setor.getIngresosDisponiveis()-quantidadeIngressos);
		
		setorRepository.save(setor);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
