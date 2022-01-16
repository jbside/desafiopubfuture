package com.pubfuture.sistema.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pubfuture.sistema.beans.Despesa;

@Repository
public class DespesaDaoImpl extends AbstractDao<Despesa, Long> implements DespesaDao{

	@Override
	public List<Despesa> findByDataInicio(LocalDate datainicio) {
		String jpql = new StringBuilder("select d from Despesa d ").append("where d.data_pagamento >= ?1 ")
				.append("order by d.data_pagamento asc").toString();
		return createQuery(jpql, datainicio);
	}

	@Override
	public List<Despesa> findByDataFinal(LocalDate datafinal) {
		String jpql = new StringBuilder("select d from Despesa d ").append("where d.data_pagamento <= ?1 ")
				.append("order by d.data_pagamento asc").toString();
		return createQuery(jpql, datafinal);
	}

	@Override
	public List<Despesa> findDatas(LocalDate datainicio, LocalDate datafinal) {
		String jpql = new StringBuilder("select d from Despesa d ")
				.append("where d.data_pagamento >= ?1 and d.data_pagamento < ?2").append("order by d.data_pagamento asc")
				.toString();
		return createQuery(jpql,datainicio,datafinal);
	}

	@Override
	public List<Despesa> findByTipo(String tipo) {
		return createQuery("select d from Despesa d where d.tipoDespesa like concat('%',?1,'%')", tipo);
	}

	

}
