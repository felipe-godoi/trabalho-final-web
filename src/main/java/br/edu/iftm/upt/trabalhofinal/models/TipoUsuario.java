package br.edu.iftm.upt.trabalhofinal.models;

public enum TipoUsuario {
	ADMIN("Admin"),
	CLIENTE("Cliente");
	
	private String descricao;
	
	private TipoUsuario(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
