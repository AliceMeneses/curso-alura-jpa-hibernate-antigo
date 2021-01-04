package br.com.alura.jpa.DAO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.MovimentacaoBancaria;

public class MovimentacaoBancariaDAO {

	private EntityManager entityManager;
	
	public List<MovimentacaoBancaria> getMovimentacoesBancariasFiltradasPorData(Integer dia, Integer mes, Integer ano){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MovimentacaoBancaria> query = criteriaBuilder.createQuery(MovimentacaoBancaria.class);
		List<Predicate> predicates = new ArrayList<>();
		
		Root<MovimentacaoBancaria> root = query.from(MovimentacaoBancaria.class);
		if(dia != null) {
			//Day(m.data)
			Expression<Integer> expressao = criteriaBuilder.function("day", Integer.class, root.<LocalDateTime>get("data"));
			//Day(m.data) = dia
			Predicate predicate = criteriaBuilder.equal(expressao, dia);
			
			predicates.add(predicate);
		}
		
		if(mes != null) {
			//Month(m.data)
			Expression<Integer> expressao = criteriaBuilder.function("month", Integer.class,root.<LocalDateTime>get("data"));
			//Month(m.data) = mes
			Predicate predicate = criteriaBuilder.equal(expressao, mes);
			
			predicates.add(predicate);
		}
		
		if(ano != null) {
			//Year(m.data)
			Expression<Integer> expressao = criteriaBuilder.function("year", Integer.class,root.<LocalDateTime>get("data"));
			//Year(m.data) = ano
			Predicate predicate = criteriaBuilder.equal(expressao, ano);
			
			predicates.add(predicate);
		}
		
		Predicate[] array = predicates.toArray(new Predicate[0]);
		query.where(array);
		
		TypedQuery<MovimentacaoBancaria> typedQuery = entityManager.createQuery(query);
		return typedQuery.getResultList();		
	}

	public MovimentacaoBancariaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public BigDecimal somaDasMovimentacoesBancarias() {
		TypedQuery<BigDecimal> query = entityManager.createNamedQuery("somaDasMovimentacoesBancarias", BigDecimal.class);
		return query.getSingleResult();
	}

	public List<MediaComData> mediaDiariasDasMovimetacoesBancarias() {
		TypedQuery<MediaComData> query = entityManager.createNamedQuery("mediaDiariasDasMovimetacoesBancarias", MediaComData.class);
		return query.getResultList();
	}
	
	public Double mediaDasMovimentacoesBancarias() {
		TypedQuery<Double> query = entityManager.createNamedQuery("mediaDasMovimentacoesBancarias", Double.class);
		return query.getSingleResult();
	}

}
