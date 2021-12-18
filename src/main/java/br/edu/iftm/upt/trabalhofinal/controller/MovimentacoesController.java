package br.edu.iftm.upt.trabalhofinal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.iftm.upt.trabalhofinal.models.Conta;
import br.edu.iftm.upt.trabalhofinal.models.Movimentacao;
import br.edu.iftm.upt.trabalhofinal.models.TipoMovimentacao;
import br.edu.iftm.upt.trabalhofinal.repository.ContaRepository;
import br.edu.iftm.upt.trabalhofinal.service.MovimentacaoService;

@Controller
@RequestMapping("/movimentacao")
public class MovimentacoesController {
	private static final Logger logger = LoggerFactory.getLogger(MovimentacoesController.class);
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Autowired
	private MovimentacaoService movimentacaoService;
	
	@GetMapping("/saque")
	public ModelAndView saque(Movimentacao movimentacao) {
		logger.trace("Entrou em cadastro de saque");
		ModelAndView mv = new ModelAndView("movimentacoes/operacoes");
		
		movimentacao.setTipo(TipoMovimentacao.SAQUE);
		mv.addObject("movimentacao", movimentacao);
		
		logger.debug("Buscando contas no banco de dados");
		List<Conta> contas = contaRepository.findAll();
		logger.debug(contas.toString());
		mv.addObject("contas", contas);
		
		logger.trace("Encaminhando para a view operacoes");
		return mv;
	}
	
	@GetMapping("/deposito")
	public ModelAndView deposito(Movimentacao movimentacao) {
		logger.trace("Entrou em cadastro de deposito");
		ModelAndView mv = new ModelAndView("movimentacoes/operacoes");
		
		movimentacao.setTipo(TipoMovimentacao.DEPOSITO);
		mv.addObject("movimentacao", movimentacao);
		
		logger.debug("Buscando contas no banco de dados");
		List<Conta> contas = contaRepository.findAll();
		logger.debug(contas.toString());
		mv.addObject("contas", contas);
		
		logger.trace("Encaminhando para a view operacoes");
		return mv;
	}
	
	@GetMapping("/transferencia")
	public ModelAndView transferencia(Movimentacao movimentacao) {
		logger.trace("Entrou em cadastro de transferencia");
		ModelAndView mv = new ModelAndView("movimentacoes/operacoes");
		
		movimentacao.setTipo(TipoMovimentacao.TRANSFERENCIA);
		mv.addObject("movimentacao", movimentacao);
		
		logger.debug(movimentacao.toString());
		
		logger.debug("Buscando contas no banco de dados");
		List<Conta> contas = contaRepository.findAll();
		logger.debug(contas.toString());
		mv.addObject("contas", contas);
		
		logger.trace("Encaminhando para a view operacoes");
		return mv;
	}
	
	@PostMapping("/novo")
	public ModelAndView novo(Movimentacao movimentacao) {
		logger.trace("Entrou na view para salvar o cadastro de saque");
		ModelAndView mv = new ModelAndView("redirect:/home");
		
		movimentacaoService.salvar(movimentacao);
		
		logger.trace("Encaminhando para o index");
		return mv;
	}
}
