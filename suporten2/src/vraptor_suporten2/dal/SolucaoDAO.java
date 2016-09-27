package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import vraptor_suporten2.model.Solucao;

@Stateless
public class SolucaoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public SolucaoDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<Solucao> listar(){

		try {
			Query query = this.entityManager.createQuery("FROM Solucao s");
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<Solucao>();
		}

	}
	
	public Solucao buscarPorNome(Solucao s){
		
		try {
			Query query = this.entityManager.createQuery("FROM Solucao s WHERE s.nome =:param1");
			query.setParameter("param1", s.getNome());
			return (Solucao) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void cadastrar(Solucao s) {
		this.entityManager.persist(s);
	}

}
