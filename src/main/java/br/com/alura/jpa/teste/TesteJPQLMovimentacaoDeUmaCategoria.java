package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class TesteJPQLMovimentacaoDeUmaCategoria {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Categoria categoria = new Categoria("Viagem");
		categoria.setId(1L);
		
		String jpql = "Select m from MovimentacaoBancaria m join m.categoria c where c = :pCategoria";
		
		TypedQuery<MovimentacaoBancaria> query = entityManager.createQuery(jpql, MovimentacaoBancaria.class);
		query.setParameter("pCategoria", categoria);
		List<MovimentacaoBancaria> movimentacoes = query.getResultList();

		for (MovimentacaoBancaria movimentacao : movimentacoes) {
			System.out.println("Categorias: " + movimentacao.getCategoria());
			System.out.println("Descrição: " + movimentacao.getDescricao());
			System.out.println("Tipo: " + movimentacao.getTipoMovimentaoBancaria());
			System.out.println("Valor: " + movimentacao.getValor());
		}
		
		entityManager.close();
		
		
	}

}
