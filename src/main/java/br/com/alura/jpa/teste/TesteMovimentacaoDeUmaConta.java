package br.com.alura.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class TesteMovimentacaoDeUmaConta {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		MovimentacaoBancaria movimentacao = entityManager.find(MovimentacaoBancaria.class, 1L);
		
		Conta conta = movimentacao.getConta();
		
		System.out.println("Titular: " + conta.getTitular());
		System.out.println("Quantidade de movimentações bancarias: " + conta.getMovimentacoes().size());
		
	}

}
