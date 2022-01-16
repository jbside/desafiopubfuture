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
public class Receita extends AbstractEntity<Long> {
	
	
	@Column(nullable = false)
	private double valor;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_recebimento", columnDefinition = "DATE" )
	private LocalDate data_recebimento;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_recebimento_esperado", columnDefinition = "DATE" )
	private LocalDate data_recebimento_esperado;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "conta_id_fk")
	private Conta conta_receita;
	
	@Column(nullable = false)
	private Integer aux;
	
	@Column(nullable = false)
	private String tipoReceita;

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public LocalDate getData_recebimento() {
		return data_recebimento;
	}

	public void setData_recebimento(LocalDate data_recebimento) {
		this.data_recebimento = data_recebimento;
	}

	public LocalDate getData_recebimento_esperado() {
		return data_recebimento_esperado;
	}

	public void setData_recebimento_esperado(LocalDate data_recebimento_esperado) {
		this.data_recebimento_esperado = data_recebimento_esperado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta_receita() {
		return conta_receita;
	}

	public void setConta_receita(Conta conta_receita) {
		this.conta_receita = conta_receita;
	}

	public String getTipoReceita() {
		return tipoReceita;
	}

	public void setTipoReceita(String tipoReceita) {
		this.tipoReceita = tipoReceita;
	}

	public Integer getAux() {
		return aux;
	}

	public void setAux(Integer aux) {
		this.aux = aux;
	}
	
	
	
	

}
