package br.com.alura.jpa.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@NamedQuery(name="somaDasMovimentacoesBancarias", query="Select sum(m.valor) From MovimentacaoBancaria m")
@NamedQuery(name="mediaDiariasDasMovimetacoesBancarias", query="Select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), Day(data), Month(data), year(data)) from MovimentacaoBancaria m group by DAY(data), MONTH(data), YEAR(DATA)")
@NamedQuery(name="mediaDasMovimentacoesBancarias", query="Select avg(m.valor) From MovimentacaoBancaria m")

@Entity
public class MovimentacaoBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private BigDecimal valor;
	@Enumerated(EnumType.STRING)
	private TipoMovimentacaoBancaria tipoMovimentaoBancaria;
	private LocalDateTime data;
	private String descricao;
	@ManyToMany
	private List<Categoria> categoria;
	@ManyToOne
	private Conta conta;
	
	@Override
	public String toString() {
		return String.format(" \n Data: %s \n Descricao: %s \n Valor: %s \n Tipo de movimentação: %s", data, descricao, valor, tipoMovimentaoBancaria);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMovimentacaoBancaria getTipoMovimentaoBancaria() {
		return tipoMovimentaoBancaria;
	}

	public void setTipoMovimentaoBancaria(TipoMovimentacaoBancaria tipoMovimentaoBancaria) {
		this.tipoMovimentaoBancaria = tipoMovimentaoBancaria;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
}
