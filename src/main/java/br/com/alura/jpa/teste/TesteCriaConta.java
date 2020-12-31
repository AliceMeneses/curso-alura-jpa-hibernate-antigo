package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteCriaConta {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Alice");
		conta.setAgencia(1234);
		conta.setNumero(4321);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(conta);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();				
	}

}
