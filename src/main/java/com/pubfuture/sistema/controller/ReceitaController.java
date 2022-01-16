package com.pubfuture.sistema.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pubfuture.sistema.beans.Conta;
import com.pubfuture.sistema.beans.Receita;
import com.pubfuture.sistema.service.ContaService;
import com.pubfuture.sistema.service.ReceitaService;

@Controller
@RequestMapping("/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Receita receita) {
		return "receita/cadastro";
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("receita", receitaService.buscarTodos());
		return "receita/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Receita receita,RedirectAttributes attr) {
		receitaService.salvar(receita);
		attr.addFlashAttribute("success","Receita salva com sucesso");
		return "redirect:/receita/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String prededitar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("receita", receitaService.buscarPorId(id));
		return "receita/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Receita receita, RedirectAttributes attr) {
		receitaService.editar(receita);
		attr.addFlashAttribute("success","Receita editada com sucesso");
		return "redirect:/receita/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		receitaService.excluir(id);
		attr.addFlashAttribute("success","Receita excluida com sucesso");
		return "redirect:/receita/lista";
	}
	
	@GetMapping("buscar/data")
	public String getDatas(@RequestParam("data_inicio") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate data_inicio,
			@RequestParam("data_final") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate data_final, ModelMap model ) {
	  model.addAttribute("despesa", receitaService.buscarPorDatas(data_inicio, data_final));
	  return "/receita/lista";
	}
	
	@GetMapping("buscar/tipo")
	public String getDatas(@RequestParam("tipo") String tipo, ModelMap model ) {
	  model.addAttribute("despesa", receitaService.buscarPorTipo(tipo));
	  return "/receita/lista";
	}
	
	@ModelAttribute("conta")
	public List<Conta> listaConta() {
		return contaService.buscarPorTodos();
	}
	

}
