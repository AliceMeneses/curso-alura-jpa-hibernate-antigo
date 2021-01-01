package br.com.alura.jpa.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;
import br.com.alura.jpa.modelo.TipoMovimentacaoBancaria;

public class TestaRelacionamento2 {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Négocios");		

		MovimentacaoBancaria movimentacaoBancaria = new MovimentacaoBancaria();
		movimentacaoBancaria.setData(LocalDateTime.now());
		movimentacaoBancaria.setDescricao("Viagem à São Paulo");
		movimentacaoBancaria.setTipoMovimentaoBancaria(TipoMovimentacaoBancaria.SAIDA);
		movimentacaoBancaria.setValor(new BigDecimal(200.0));
		movimentacaoBancaria.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacaoBancaria.setConta(conta);
		
		MovimentacaoBancaria movimentacaoBancaria2 = new MovimentacaoBancaria();
		movimentacaoBancaria2.setData(LocalDateTime.now());
		movimentacaoBancaria2.setDescricao("Viagem ao Rio de Janeiro");
		movimentacaoBancaria2.setTipoMovimentaoBancaria(TipoMovimentacaoBancaria.SAIDA);
		movimentacaoBancaria2.setValor(new BigDecimal(400.0));
		movimentacaoBancaria2.setCategoria(Arrays.asList(categoria, categoria2));
		movimentacaoBancaria2.setConta(conta);
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(categoria);
		entityManager.persist(categoria2);
		entityManager.persist(movimentacaoBancaria);
		entityManager.persist(movimentacaoBancaria2);
		
		System.out.println(conta.getTitular());
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		
		
	}

}
