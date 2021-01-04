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
		String jpql = "Select sum(m.valor) From MovimentacaoBancaria m";
		TypedQuery<BigDecimal> query = entityManager.createQuery(jpql, BigDecimal.class);
		return query.getSingleResult();
	}

	public List<MediaComData> mediaDiariasDasMovimetacoesBancarias() {
		String jpql = "Select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), Day(data), Month(data), year(data)) from MovimentacaoBancaria m group by DAY(data), MONTH(data), YEAR(DATA)";
		TypedQuery<MediaComData> query = entityManager.createQuery(jpql, MediaComData.class);
		return query.getResultList();
	}
	
	public Double mediaDasMovimentacoesBancarias() {
		String jpql = "Select avg(m.valor) From MovimentacaoBancaria m";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		return query.getSingleResult();
	}

}
