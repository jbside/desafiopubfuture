package com.pubfuture.sistema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pubfuture.sistema.beans.Conta;
import com.pubfuture.sistema.dao.ContaDao;

@Service
@Transactional(readOnly = true)
public class ContaServiceImpl implements ContaService{
	
	@Autowired
	private ContaDao dao;
	
	@Autowired
	ContaService contaService;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Conta conta) {
		dao.save(conta);
	}

	@Transactional(readOnly = false) 
	@Override
	public void editar(Conta conta) {
		dao.update(conta);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Conta buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Conta> buscarPorTodos() {
		return dao.findAll();
	}
     
	@Transactional(readOnly = false)
	@Override
	public boolean tranferenciaConta(Long id1, Long id2, double valor) {
		
		double saldo1 = contaService.buscarPorId(id1).getSaldo();
		double saldo2 = contaService.buscarPorId(id2).getSaldo();
		
		if ((valor < 0) || (valor > saldo1) || (id1 == id2)){
	       return false;
		} else {
			contaService.buscarPorId(id2).setSaldo(valor+saldo2); 
			contaService.buscarPorId(id1).setSaldo(saldo1-valor); 
			return true;
		}	
	}	

}
