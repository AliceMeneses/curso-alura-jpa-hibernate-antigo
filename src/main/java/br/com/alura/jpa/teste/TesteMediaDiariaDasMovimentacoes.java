package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.DAO.MovimentacaoBancariaDAO;
import br.com.alura.jpa.modelo.MediaComData;

public class TesteMediaDiariaDasMovimentacoes {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		List<MediaComData> medias = new MovimentacaoBancariaDAO(entityManager).mediaDiariasDasMovimetacoesBancarias();
		
		for (MediaComData media : medias) {
			System.out.printf("Data: %s/%s/%s - Média das movimentações bancárias: R$ %.2f", media.getDia(), media.getMes(), media.getAno(), media.getValor());
			System.out.println();
		}
		
		entityManager.close();				
	}

}
