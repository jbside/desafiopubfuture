package com.pubfuture.sistema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pubfuture.sistema.beans.Conta;
import com.pubfuture.sistema.service.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService contaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Conta conta) {
		return "conta/cadastro";
	}
	
	@GetMapping("/transferencia")
	public String tranferencia(Conta conta) {
		return "conta/tranferencia";
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("conta", contaService.buscarPorTodos());
		return "conta/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Conta conta,RedirectAttributes attr) {
		contaService.salvar(conta);
		attr.addFlashAttribute("success", "Conta salva com sucesso!");
		return "redirect:/conta/lista";
	}
	
	@GetMapping("/editar/{id}")
	public String preeditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("conta", contaService.buscarPorId(id));
		return "conta/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Conta conta,RedirectAttributes attr) {
		contaService.editar(conta);
		attr.addFlashAttribute("success", "Conta editada com sucesso");
		return "redirect:/conta/lista";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id) {
		contaService.excluir(id);
		return "redirect:/conta/lista";
	}
	
	@PostMapping("/transferir")
	public String tranfereConta(@RequestParam("id1") Long id1, @RequestParam("id2") Long id2, @RequestParam("valor") double valor,
			RedirectAttributes attr) {
		
		if (contaService.tranferenciaConta(id1,id2, valor)){
			attr.addFlashAttribute("success","Transferência realizada com sucesso");
			return "redirect:/conta/lista";
		} else {
            attr.addFlashAttribute("fail","Ops, ocorreu um erro, verifique se a conta realmente tem saldo suficiente para a transferência ou se foram digitados as contas corretamente");
			return "redirect:/conta/transferencia";		   
 	    }
	}
	
	
}	
	
	
	
	
