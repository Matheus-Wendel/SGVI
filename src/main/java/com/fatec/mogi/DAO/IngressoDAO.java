package com.fatec.mogi.DAO;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.model.Ingresso;
import com.fatec.mogi.repository.IngressoRepository;
@Service
public class IngressoDAO implements IDAO {

	@Autowired
	IngressoRepository ingressoRepository;

	@Override
	public BaseModel save(BaseModel baseModel) {
		Ingresso ingreeso = (Ingresso) baseModel;
		ingressoRepository.save(ingreeso);
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
	public List<Ingresso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Ingresso> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ingresso> findByParameter(String parametro) {
		
		return ingressoRepository.findIngressosCliente(parametro);
	}
	
	
	public int countIngressoDoAno(Long id,Date date) {
		return ingressoRepository.countIngressoDoAno(id,date);
	}
	
	public List<Ingresso> findIngressosParaBonus(Long id, Date date) {
		return ingressoRepository.findIngressosParaBonus(id, date);
		
		
	}
	public void saveAll(List<Ingresso> ingresso) {
		ingressoRepository.saveAll(ingresso);
	}

	@Override
	public BaseModel findByParameter(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
