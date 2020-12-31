package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TestandoEstados {

	public static void main(String[] args) {

		//Transient
		Conta conta = new Conta();
		conta.setTitular("Ricardo");
		conta.setAgencia(123456);
		conta.setNumero(654321);
		conta.setSaldo(200.0);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Transient -> Managed
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		
		//Managed -> Removed
		entityManager.remove(conta);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
	}

}
