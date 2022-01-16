package com.pubfuture.sistema.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pubfuture.sistema.beans.Receita;

@Repository
public class ReceitaDaoImpl extends AbstractDao<Receita, Long> implements ReceitaDao{

	@Override
	public List<Receita> findByDataInicial(LocalDate datainicial) {
		String jpql = new StringBuilder("select r from Receita r ").append("where r.data_recebimento >= ?1 ")
				.append("order by d.data_recebimento asc").toString();
		return createQuery(jpql, datainicial);
	}

	@Override
	public List<Receita> findByDataFinal(LocalDate datafinal) {
		String jpql = new StringBuilder("select r from Receita r ").append("where r.data_recebimento <= ?1 ")
				.append("order by d.data_recebimento asc").toString();
		return createQuery(jpql, datafinal);
	}

	@Override
	public List<Receita> findDatas(LocalDate datainicio, LocalDate datafinal) {
		String jpql = new StringBuilder("select r from Receita r ")
				.append("where r.data_recebimento >= ?1 and r.data_recebimento < ?2").append("order by r.data_recebimento asc")
				.toString();
		return createQuery(jpql,datainicio,datafinal);
	}

	@Override
	public List<Receita> findByTipo(String tipo) {
		return createQuery("select r from Receita r where r.tipoReceita like concat('%',?1,'%')", tipo);
	}

}
