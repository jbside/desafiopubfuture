package com.pubfuture.sistema.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pubfuture.sistema.beans.Despesa;
import com.pubfuture.sistema.dao.DespesaDao;

@Service
@Transactional(readOnly = true)
public class DespesaServiceImpl implements DespesaService {
	
	@Autowired
	private DespesaDao dao;


	@Transactional(readOnly = false)
	@Override
	public void salvar(Despesa despesa) {
		despesa.setAux(1);
		dao.save(despesa);	
	}
    
	@Transactional(readOnly = false)
	@Override
	public void editar(Despesa despesa) {
		despesa.setAux(1);
		dao.update(despesa);	
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Despesa buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Despesa> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Despesa> buscarPorTipo(String tipo) {
		return dao.findByTipo(tipo);
	}

	@Override
	public List<Despesa> buscarPorDatas(LocalDate datainicio, LocalDate datafinal) {
		if (datainicio != null && datafinal != null) {
			return dao.findDatas(datainicio, datafinal);
		} else if (datainicio != null) {
			return dao.findByDataInicio(datainicio);
		} else if (datafinal != null) {
			return dao.findByDataFinal(datafinal);
		} else {
			return new ArrayList<>();
		}
	}
	
}
