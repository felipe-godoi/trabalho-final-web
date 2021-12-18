package br.edu.iftm.upt.trabalhofinal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.iftm.upt.trabalhofinal.models.Conta;
import br.edu.iftm.upt.trabalhofinal.repository.ContaRepository;


@Service
public class ContaService {
	
	private static final Logger logger = LoggerFactory.getLogger(ContaService.class);
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Transactional
	public void salvar(Conta conta) {
		logger.trace("Entrou em salvar");
		logger.debug("Salvando o conta {}", conta);
		contaRepository.save(conta);
		logger.debug("Conta salvo com sucesso {}", conta);
	}

}
