package br.com.alura.jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class TesteCriteriaSomaDasMovimentacoesBancarias {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> query = criteriaBuilder.createQuery(BigDecimal.class);
		
		Root<MovimentacaoBancaria> root = query.from(MovimentacaoBancaria.class);
		
		Expression<BigDecimal> expression = criteriaBuilder.sum(root.<BigDecimal>get("valor"));
		query.select(expression);
		
		TypedQuery<BigDecimal> typedQuery = entityManager.createQuery(query);
		System.out.println("Valor total das movimentações bancárias: R$" + typedQuery.getSingleResult());

	}

}
