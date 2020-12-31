package br.com.alura.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;
import br.com.alura.jpa.modelo.TipoMovimentacaoBancaria;

public class TestaRelacionamento {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Gabi");
		conta.setAgencia(123456);
		conta.setNumero(654321);
		conta.setSaldo(900.0);
		
		MovimentacaoBancaria movimentacao = new MovimentacaoBancaria();
		movimentacao.setConta(conta);
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setValor(new BigDecimal(200.0));
		movimentacao.setTipoMovimentaoBancaria(TipoMovimentacaoBancaria.SAIDA);
		movimentacao.setDescricao("Churrasco");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		entityManager.persist(conta);
		entityManager.persist(movimentacao);
		entityManager.getTransaction().commit();
		
		entityManager.close();
	}

}
