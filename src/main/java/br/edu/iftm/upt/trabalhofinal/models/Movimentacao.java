package br.edu.iftm.upt.trabalhofinal.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao implements Serializable{
	private static final long serialVersionUID = -4393797406662224543L;
	
	@Id
	@SequenceGenerator(name = "gerador", sequenceName = "movimentacao_codigo_seq", allocationSize = 1)
	@GeneratedValue(generator = "gerador", strategy = GenerationType.SEQUENCE)
	public Long codigo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_conta_origem")
	public Conta origem;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_conta_destino")
	public Conta destino;
	public Double valor;
	@Enumerated(EnumType.STRING)
	public TipoMovimentacao tipo;
	public LocalDate data;
	public LocalTime hora;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Conta getOrigem() {
		return origem;
	}

	public void setOrigem(Conta origem) {
		this.origem = origem;
	}

	public Conta getDestino() {
		return destino;
	}

	public void setDestino(Conta destino) {
		this.destino = destino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoMovimentacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoMovimentacao tipo) {
		this.tipo = tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(codigo, other.codigo);
	}

	@Override
	public String toString() {
		return "Movimentacao [codigo=" + codigo + ", valor=" + valor + ", tipo=" + tipo + ", data=" + data + ", hora="
				+ hora + "]";
	}
}
