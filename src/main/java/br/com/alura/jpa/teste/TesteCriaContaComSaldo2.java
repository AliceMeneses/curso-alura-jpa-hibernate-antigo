package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteCriaContaComSaldo2 {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Alex");
		conta.setAgencia(123456);
		conta.setNumero(654321);
		conta.setSaldo(200.0);
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		conta.setSaldo(5000.0);
		
		EntityManager entityManager2 = entityManagerFactory.createEntityManager();
		entityManager2.merge(conta);

		
	}

}
