package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;

public class TesteRelatorioDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select c from Conta c left join fetch c.movimentacoes";
		TypedQuery<Conta> query = entityManager.createQuery(jpql, Conta.class);
		List<Conta> contas = query.getResultList();
		
		for(Conta conta : contas) {
			System.out.println("Titular: " + conta.getTitular());
			System.out.println("Agencia: " + conta.getAgencia());
			System.out.println("Número: " + conta.getNumero());
			System.out.println("Movimentações: " + conta.getMovimentacoes());
		}
		
	}

}
