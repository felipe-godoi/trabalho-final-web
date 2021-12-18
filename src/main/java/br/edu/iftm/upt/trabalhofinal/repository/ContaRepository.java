package br.edu.iftm.upt.trabalhofinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.upt.trabalhofinal.models.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
