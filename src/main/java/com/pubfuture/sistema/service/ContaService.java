package com.pubfuture.sistema.service;

import java.util.List;

import com.pubfuture.sistema.beans.Conta;

public interface ContaService {
	
	void salvar(Conta conta);
	
	void editar(Conta conta);
	
	void excluir(Long id);
	
	Conta buscarPorId(Long id);
	
	List<Conta> buscarPorTodos();
	
	boolean tranferenciaConta(Long id1, Long id2, double valor);
	
}
