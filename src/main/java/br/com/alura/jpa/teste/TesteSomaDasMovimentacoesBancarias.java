package br.com.alura.jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteSomaDasMovimentacoesBancarias {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select sum(m.valor) From MovimentacaoBancaria m";
		TypedQuery<BigDecimal> query = entityManager.createQuery(jpql, BigDecimal.class);
		BigDecimal somaDasMovimentacoes = query.getSingleResult();
		
		System.out.println("Valor total das movimentações bancárias: R$" + somaDasMovimentacoes);
		
		entityManager.close();
	}

}
