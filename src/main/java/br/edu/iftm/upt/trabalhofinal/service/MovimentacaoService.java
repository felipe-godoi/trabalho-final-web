package br.edu.iftm.upt.trabalhofinal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.trabalhofinal.models.Movimentacao;
import br.edu.iftm.upt.trabalhofinal.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
private static final Logger logger = LoggerFactory.getLogger(MovimentacaoService.class);
	
	@Autowired
	private MovimentacaoRepository movimentacaoRepository;
	
	@Transactional
	public void salvar(Movimentacao movimentacao) {
		logger.trace("Entrou em salvar");
		logger.debug("Salvando a movimentação {}", movimentacao);
		movimentacaoRepository.save(movimentacao);
		logger.debug("Movimentação salva com sucesso {}", movimentacao);
	}
}
