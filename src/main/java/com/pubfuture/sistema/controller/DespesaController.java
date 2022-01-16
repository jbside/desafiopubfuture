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
import com.pubfuture.sistema.beans.Despesa;
import com.pubfuture.sistema.service.ContaService;
import com.pubfuture.sistema.service.DespesaService;


@Controller
@RequestMapping("/despesa")
public class DespesaController {
	
	@Autowired
	private DespesaService despesaService;
	
	@Autowired
	private ContaService contaService;

	
	@GetMapping("/cadastrar")
	public String cadastrar(Despesa despesa) {
		return "/despesa/cadastro";
	}
	
	@GetMapping("/lista")
	public String listar(ModelMap model) {
		model.addAttribute("despesa", despesaService.buscarTodos());
		return "despesa/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Despesa despesa, RedirectAttributes attr) {
		despesaService.salvar(despesa);
		attr.addFlashAttribute("success", "Despesa salva com sucesso");
		return "redirect:/despesa/lista";
	}

	@GetMapping("/editar/{id}")
	public String preeditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("despesa", despesaService.buscarPorId(id));
		return "despesa/cadastro";
	}

	
	@PostMapping("/editar")
	public String editar(Despesa despesa, RedirectAttributes attr) {
		despesaService.editar(despesa);
		attr.addFlashAttribute("success","Despesa editada com sucesso");
		return "redirect:/despesa/lista";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		despesaService.excluir(id);
		attr.addFlashAttribute("success","Despesa excluida com sucesso");
		return "despesa/lista";
	}
	
	@GetMapping("buscar/data")
	public String getDatas(@RequestParam("data_inicio") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate data_inicio,
			@RequestParam("data_final") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate data_final, ModelMap model ) {
	  model.addAttribute("despesa", despesaService.buscarPorDatas(data_inicio, data_final));
	  return "/despesa/lista";
	}
	
	@GetMapping("buscar/tipo")
	public String getDatas(@RequestParam("tipo") String tipo, ModelMap model ) {
	  model.addAttribute("despesa", despesaService.buscarPorTipo(tipo));
	  return "/despesa/lista";
	}
	
	@ModelAttribute("conta")
	public List<Conta> listaConta() {
		return contaService.buscarPorTodos();
	}

}
