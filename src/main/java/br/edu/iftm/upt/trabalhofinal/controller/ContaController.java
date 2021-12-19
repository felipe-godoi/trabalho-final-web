package br.edu.iftm.upt.trabalhofinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.upt.trabalhofinal.models.Conta;
import br.edu.iftm.upt.trabalhofinal.service.ContaService;

@Controller
@RequestMapping("/conta")
public class ContaController {
	private static final Logger logger = LoggerFactory.getLogger(ContaController.class);
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping("/cadastrar")
	public ModelAndView cadastroConta() {
		logger.trace("Entrou em cadastro de contas");
		ModelAndView mv = new ModelAndView("conta/cadastro-conta");
		logger.trace("Encaminhando para a view cadastro-conta");
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView novo(Conta conta) {
		logger.trace("Entrou em conta/novo");
		
		logger.debug(conta.toString());
		
		contaService.salvar(conta);
		
		ModelAndView mv = new ModelAndView("redirect:/home");
		logger.trace("Encaminhando para a view index");
		return mv;
	}
}
