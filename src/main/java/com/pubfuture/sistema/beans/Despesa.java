package com.pubfuture.sistema.beans;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table
public class Despesa extends AbstractEntity<Long> {
	
	
	@Column(nullable = false)
	private double valor;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_pagamento", columnDefinition = "DATE" )
	private LocalDate data_pagamento;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_recebimento_esperado", columnDefinition = "DATE" )
	private LocalDate data_pagamento_esperado;
	
	@Column(nullable = false)
	private Integer aux;
	
	@Column(nullable = false)
	private String tipoDespesa;
	
	@ManyToOne
	@JoinColumn(name = "conta_id_fk")
	private Conta conta_despesa;
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(LocalDate data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public LocalDate getData_pagamento_esperado() {
		return data_pagamento_esperado;
	}

	public void setData_pagamento_esperado(LocalDate data_pagamento_esperado) {
		this.data_pagamento_esperado = data_pagamento_esperado;
	}


	public Integer getAux() {
		return aux;
	}

	public void setAux(Integer aux) {
		this.aux = aux;
	}

	public Conta getConta_despesa() {
		return conta_despesa;
	}

	public void setConta_despesa(Conta conta_despesa) {
		this.conta_despesa = conta_despesa;
	}

	public String getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(String tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
	
	

}
