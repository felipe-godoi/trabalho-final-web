package br.edu.iftm.upt.trabalhofinal.models;

public enum TipoMovimentacao {
	SAQUE("Saque"),
	DEPOSITO("Deposito"),
	TRANSFERENCIA("Transferencia");
	
	private String descricao;
	
	private TipoMovimentacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
