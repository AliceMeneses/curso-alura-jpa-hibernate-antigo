package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select avg(m.valor) from MovimentacaoBancaria m group by DAY(data), MONTH(data), YEAR(DATA)";
		
		TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
		
		List<Double> medias = query.getResultList();
		
		for (Double media : medias) {
			System.out.println("Média das movimentações bancárias: R$" + media);
		}
		
		entityManager.close();				
	}

}
