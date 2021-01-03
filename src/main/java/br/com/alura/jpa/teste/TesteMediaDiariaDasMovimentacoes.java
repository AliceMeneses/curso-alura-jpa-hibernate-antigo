package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select avg(m.valor), Day(data), Month(data), year(data) from MovimentacaoBancaria m group by DAY(data), MONTH(data), YEAR(DATA)";
		
		Query query = entityManager.createQuery(jpql);
		
		List<Object[]> medias = query.getResultList();
		
		for (Object[] media : medias) {
			System.out.printf("Data: %s/%s/%s - Média das movimentações bancárias: R$ %.2f", media[1], media[2], media[3], media[0]);
			System.out.println();
		}
		
		entityManager.close();				
	}

}
