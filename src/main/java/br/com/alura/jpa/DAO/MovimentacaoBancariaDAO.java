package br.com.alura.jpa.DAO;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class MovimentacaoBancariaDAO {

	private EntityManager entityManager;

	public MovimentacaoBancariaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public BigDecimal somaDasMovimentacoesBancarias() {
		TypedQuery<BigDecimal> query = entityManager.createNamedQuery("somaDasMovimentacoesBancarias", BigDecimal.class);
		return query.getSingleResult();
	}

	public List<MediaComData> mediaDiariasDasMovimetacoesBancarias() {
		TypedQuery<MediaComData> query = entityManager.createNamedQuery("mediaDiariasDasMovimetacoesBancarias", MediaComData.class);
		return query.getResultList();
	}
	
	public Double mediaDasMovimentacoesBancarias() {
		TypedQuery<Double> query = entityManager.createNamedQuery("mediaDasMovimentacoesBancarias", Double.class);
		return query.getSingleResult();
	}

}
