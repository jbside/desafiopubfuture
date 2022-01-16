package com.pubfuture.sistema.service;

import java.time.LocalDate;
import java.util.List;

import com.pubfuture.sistema.beans.Receita;

public interface ReceitaService {
	
	void salvar(Receita receita);
	
	void editar(Receita receita);
	
	void excluir(Long id);
	
	Receita buscarPorId(Long id);
	
	List<Receita> buscarTodos();
	
	List<Receita> buscarPorTipo(String tipo);
	
	List<Receita> buscarPorDatas(LocalDate datainicio, LocalDate datafinal);

}
