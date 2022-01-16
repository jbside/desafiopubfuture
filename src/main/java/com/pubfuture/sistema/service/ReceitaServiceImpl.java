package com.pubfuture.sistema.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pubfuture.sistema.beans.Receita;
import com.pubfuture.sistema.dao.ReceitaDao;

@Service
@Transactional(readOnly = true)
public class ReceitaServiceImpl implements ReceitaService {
	
	@Autowired
	private ReceitaDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Receita receita) {
		receita.setAux(1);
		dao.save(receita);
		
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Receita receita) {
		receita.setAux(1);
		dao.update(receita);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override
	public Receita buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Receita> buscarTodos() {
		return dao.findAll();
	}

	@Override
	public List<Receita> buscarPorTipo(String tipo) {
		return dao.findByTipo(tipo);
	}

	@Override
	public List<Receita> buscarPorDatas(LocalDate datainicio, LocalDate datafinal) {
		if (datainicio != null && datafinal != null) {
			return dao.findDatas(datainicio, datafinal);
		} else if (datainicio != null) {
			return dao.findByDataInicial(datainicio);
		} else if (datafinal != null) {
			return dao.findByDataFinal(datafinal);
		} else {
			return new ArrayList<>();
		}
	}
	
	

}
