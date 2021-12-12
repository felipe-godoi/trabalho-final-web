package br.edu.iftm.upt.trabalhofinal.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="conta")
public class Conta implements Serializable{
	private static final long serialVersionUID = 7908513635280638608L;

	@Id
	@SequenceGenerator(name = "gerador", sequenceName = "conta_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador", strategy = GenerationType.SEQUENCE)
	public Long codigo;
	public String numero;
	public Double saldo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_usuario")
	public Usuario usuario;
	@Column(name="data_criacao")
	public LocalDate dataCriacao;
	@Column(name="hora_criacao")
	public LocalTime horaCriacao;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalTime getHoraCriacao() {
		return horaCriacao;
	}

	public void setHoraCriacao(LocalTime horaCriacao) {
		this.horaCriacao = horaCriacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Conta [codigo=" + codigo + ", numero=" + numero + ", saldo=" + saldo + ", dataCriacao=" + dataCriacao
				+ ", horaCriacao=" + horaCriacao + "]";
	}
}
