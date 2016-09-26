package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vraptor_suporten2.model.Rede;

@Stateless
public class RedeDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public RedeDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<Rede> listar(){

		try {
			Query query = this.entityManager.createQuery("FROM Rede r");
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<Rede>();
		}

	}

	public void cadastrar(Rede rede) {
		this.entityManager.persist(rede);
	}

}
