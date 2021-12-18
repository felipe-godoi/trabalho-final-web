package br.edu.iftm.upt.trabalhofinal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.upt.trabalhofinal.repository.ContaRepository;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private ContaRepository contaRepository;

	@GetMapping(value = {"/", "/index.html"} )
	public ModelAndView index() {
		logger.trace("Entrou em index");
		ModelAndView mv = new ModelAndView("index");
		
		logger.trace("Encaminhando para a view index");
		return mv;
	}
	
}
