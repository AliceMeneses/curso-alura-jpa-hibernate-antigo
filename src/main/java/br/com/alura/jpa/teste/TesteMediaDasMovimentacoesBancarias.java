package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.DAO.MovimentacaoBancariaDAO;

public class TesteMediaDasMovimentacoesBancarias {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Double mediaDasMovimentacoes = new MovimentacaoBancariaDAO(entityManager).mediaDasMovimentacoesBancarias();
		
		System.out.println("M�dia das movimenta��es banc�rias: R$" + mediaDasMovimentacoes);
		
		entityManager.close();
	}

}
