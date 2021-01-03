package br.com.alura.jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteMediaDasMovimentacoesBancarias {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select avg(m.valor) From MovimentacaoBancaria m";
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		Double somaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("Valor total das movimentações bancárias: R$" + somaDasMovimentacoes);
		
		entityManager.close();
	}

}
