package com.pubfuture.sistema.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.pubfuture.sistema.beans.Conta;
import com.pubfuture.sistema.service.ContaService;


@Component
public class StringToContaConversor implements Converter<String,Conta> {

	@Autowired
	private ContaService service;
	
	@Override
	public Conta convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);
	}

}
