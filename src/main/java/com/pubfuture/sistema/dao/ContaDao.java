package com.pubfuture.sistema.dao;

import java.util.List;

import com.pubfuture.sistema.beans.Conta;

public interface ContaDao {

	void save (Conta conta);
	
	void update (Conta conta);
	
	void delete (Long id);
	
	Conta findById(Long id);
	
	List<Conta> findAll();
	
}
