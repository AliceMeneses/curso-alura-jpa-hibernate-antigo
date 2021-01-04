package br.com.alura.jpa.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.DAO.MovimentacaoBancariaDAO;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class TesteMovimentacoesFiltradasPorData {

	public static void main(String[] args) {

		EntityManagerFactory entitymanagerFactory = Persistence.createEntityManagerFactory("contas");
		EntityManager entityManager = entitymanagerFactory.createEntityManager();
		
		MovimentacaoBancariaDAO movimentacaoBancariaDAO = new MovimentacaoBancariaDAO(entityManager);
		List<MovimentacaoBancaria> movimentacoesBancarias = movimentacaoBancariaDAO.getMovimentacoesBancariasFiltradasPorData(null, null, null);
		
		movimentacoesBancarias.forEach(System.out::println);
		
	}

}
