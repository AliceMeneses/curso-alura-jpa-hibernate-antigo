package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TesteRelacionamentoClienteConta {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
		EntityManager em = emf.createEntityManager();

		Conta conta = new Conta();
		conta.setId(1L);

		Cliente cliente = new Cliente();
		cliente.setNome("Alice");
		cliente.setEndereco("Rua do Ouvidor, 50");
		cliente.setProfissao("Dev");
		cliente.setConta(conta);

		em.getTransaction().begin();

		em.persist(cliente);

		em.getTransaction().commit();
		em.close();
	}

}
