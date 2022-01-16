package com.pubfuture.sistema.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CONTA")
public class Conta extends AbstractEntity<Long> {
	
	@Column(nullable = false)
	private double saldo;
	
	@Column(nullable = false)
	private String tipoConta;
	
	@Column(nullable = false)
	private String instituicaoFinanceira;


	public String getTipoConta() {
		return tipoConta;
	}

	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getInstituicaoFinanceira() {
		return instituicaoFinanceira;
	}

	public void setInstituicaoFinanceira(String instituicaoFinanceira) {
		this.instituicaoFinanceira = instituicaoFinanceira;
	}
	
	
			

}
