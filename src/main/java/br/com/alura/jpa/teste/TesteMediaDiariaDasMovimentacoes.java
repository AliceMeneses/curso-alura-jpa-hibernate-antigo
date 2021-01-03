package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String jpql = "Select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), Day(data), Month(data), year(data)) from MovimentacaoBancaria m group by DAY(data), MONTH(data), YEAR(DATA)";
		
		TypedQuery<MediaComData> query = entityManager.createQuery(jpql, MediaComData.class);
		
		List<MediaComData> medias = query.getResultList();
		
		for (MediaComData media : medias) {
			System.out.printf("Data: %s/%s/%s - Média das movimentações bancárias: R$ %.2f", media.getDia(), media.getMes(), media.getAno(), media.getValor());
			System.out.println();
		}
		
		entityManager.close();				
	}

}
