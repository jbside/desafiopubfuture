package com.pubfuture.sistema.dao;

import java.time.LocalDate;
import java.util.List;

import com.pubfuture.sistema.beans.Despesa;

public interface DespesaDao {
	
	void save(Despesa despesa);
	
	void update(Despesa despesa);
	
	void delete(Long id);
	
	Despesa findById(Long id);
	
	List<Despesa> findAll();
	
	List<Despesa> findByDataInicio(LocalDate datainicio);
	
	List<Despesa> findByDataFinal(LocalDate datafinal);
	
	List<Despesa> findDatas(LocalDate datainicio,LocalDate datafinal);
	
	List<Despesa> findByTipo(String tipo);

}
