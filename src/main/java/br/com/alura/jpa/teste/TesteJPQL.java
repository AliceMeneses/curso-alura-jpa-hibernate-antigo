package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class TesteJPQL {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Conta conta = new Conta();
		conta.setId(1L);

		String jpql = "Select m from MovimentacaoBancaria m where m.conta = :pConta order by m.valor desc";

		TypedQuery<MovimentacaoBancaria> query = entityManager.createQuery(jpql, MovimentacaoBancaria.class);
		query.setParameter("pConta", conta);
		List<MovimentacaoBancaria> movimentacoes = query.getResultList();

		for (MovimentacaoBancaria movimentacao : movimentacoes) {
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentaoBancaria());
			System.out.println("Valor: " + movimentacao.getValor());
		}
		
		entityManager.close();
	}

}
