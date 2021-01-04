package br.com.alura.jpa.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.DAO.MovimentacaoBancariaDAO;

public class TesteSomaDasMovimentacoesBancarias {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		BigDecimal somaDasMovimentacoes = new MovimentacaoBancariaDAO(entityManager).somaDasMovimentacoesBancarias();
		
		System.out.println("Valor total das movimentações bancárias: R$" + somaDasMovimentacoes);
		
		entityManager.close();
	}

}
