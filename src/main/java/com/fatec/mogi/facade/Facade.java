package com.fatec.mogi.facade;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.mogi.DAO.IDAO;
import com.fatec.mogi.model.BaseModel;
import com.fatec.mogi.strategy.IStrategy;
import com.fatec.mogi.strategy.UtilStrategy;

@Service
public class Facade {


	@Autowired
	private UtilStrategy utilStrategy;

	private Map<String, IDAO> mapDAO;

	@Autowired
	public Facade(Map<String, IDAO> mapDAO) {
		this.mapDAO = mapDAO;
		

//		for (String s : mapDAO.keySet()) {
//			System.err.println(s);
//		}
	}

	public BaseModel salvar(BaseModel baseModel) {
		
	
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");
		List<IStrategy> stgGenerico = utilStrategy.montaListaStrategy(baseModel.getClass().getSimpleName().toLowerCase()+"SALVAR");
		
		if(stgGenerico == null) 
			return daoGenerico.save(baseModel);
		

		String resVal = "";
		for (IStrategy strategy : stgGenerico) {
			resVal += strategy.processar(baseModel);
		}

		if (resVal.equals("")) {
			return daoGenerico.save(baseModel);
		}

		System.out.println("Situação: " + resVal);
		return null;
	}

	public BaseModel atualizar(BaseModel baseModel, Long id) {

		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");
		List<IStrategy> stgGenerico = utilStrategy.montaListaStrategy(baseModel.getClass().getSimpleName().toLowerCase()+"ATUALIZAR");
		
		if(stgGenerico == null)
			return daoGenerico.update(baseModel, id);
		
		String resVal = "";
		for (IStrategy strategy : stgGenerico) {
			resVal += strategy.processar(baseModel);
		}
		
		if (resVal.equals(""))
			return daoGenerico.update(baseModel, id);
		
		System.out.println("Situação: " + resVal);
		return null;
			
	}

	@SuppressWarnings("unchecked")
	public List<BaseModel> BuscarPorParmetro(BaseModel baseModel, String parametro) {
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");

		return daoGenerico.findByParameter(parametro);

	}
	public BaseModel BuscarPorParmetro(BaseModel baseModel, Long parametro) {
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");
		
		return daoGenerico.findByParameter(parametro);
		
	}

	@SuppressWarnings("unchecked")
	public List<BaseModel> BuscarTodos(BaseModel baseModel) {
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");

		return daoGenerico.findAll();
	}

	@SuppressWarnings("unchecked")
	public Optional<BaseModel> BuscarPorId(BaseModel baseModel, Long id) {
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");

		return daoGenerico.findById(id);
	}

	public String deletar(BaseModel baseModel,Long id) {
		IDAO daoGenerico = mapDAO.get(baseModel.getClass().getSimpleName().toLowerCase() + "DAO");
		List<IStrategy> stgGenerico = utilStrategy.montaListaStrategy(baseModel.getClass().getSimpleName().toLowerCase()+"DELETAR");
//		daoGenerico.delete(id);
		
		if(stgGenerico == null)
			return daoGenerico.delete(id);
			
		

		String resVal = "";
		for (IStrategy strategy : stgGenerico) {
			resVal += strategy.processar(baseModel);
		}

		if (resVal.equals("")) {
			return daoGenerico.delete(id);
		}

		return ("Situação: " + resVal);

	}

}
