package com.pubfuture.sistema.service;

import java.time.LocalDate;
import java.util.List;

import com.pubfuture.sistema.beans.Despesa;

public interface DespesaService {
	
	void salvar(Despesa despesa);
	
	void editar(Despesa despesa);
	
	void excluir(Long id);
	
	Despesa buscarPorId(Long id);
	
	List<Despesa> buscarTodos();
	
	List<Despesa> buscarPorTipo(String tipo);
	
	List<Despesa> buscarPorDatas(LocalDate datainicio,LocalDate datafinal);

}
