package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vraptor_suporten2.model.entities.Solucao;

@Stateless
public class SolucaoDAO extends AbstractDAO{

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

}
