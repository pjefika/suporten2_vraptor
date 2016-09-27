package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import vraptor_suporten2.model.Atendimento;

@Stateless
public class AtendimentoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public AtendimentoDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<Atendimento> listar(){

		try {
			Query query = this.entityManager.createQuery("FROM Atendimento s");
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<Atendimento>();
		}

	}
	
	public void cadastrar(Atendimento s) {
		this.entityManager.persist(s);
	}

}
