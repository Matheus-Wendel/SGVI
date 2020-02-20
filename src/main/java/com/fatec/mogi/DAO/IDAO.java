package com.fatec.mogi.DAO;

import java.util.List;
import java.util.Optional;

import com.fatec.mogi.model.BaseModel;

public interface IDAO {

	public BaseModel save(BaseModel baseModel);

	public String delete(Long id);
	
	public BaseModel update(BaseModel baseModel, Long id);
	
	@SuppressWarnings("rawtypes")
	public List findAll();
	
	@SuppressWarnings("rawtypes")
	public Optional findById(Long id);
	
	@SuppressWarnings("rawtypes")
	public List findByParameter(String parametro);
	@SuppressWarnings("rawtypes")
	public BaseModel findByParameter(Long id);

	
}
