package com.pubfuture.sistema.dao;

import java.time.LocalDate;
import java.util.List;

import com.pubfuture.sistema.beans.Receita;

public interface ReceitaDao {
	
	void save(Receita receita);
	
	void update(Receita receita);
	
	void delete(Long id);
	
	Receita findById(Long id);
	
	List<Receita> findAll();
	
	List<Receita> findByDataInicial(LocalDate datainicial);
	
	List<Receita> findByDataFinal(LocalDate datafinal);
	
	List<Receita> findDatas(LocalDate datainicio, LocalDate datafinal);
	
	List<Receita> findByTipo(String tipo);

}
