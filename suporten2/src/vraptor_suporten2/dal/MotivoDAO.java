package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vraptor_suporten2.model.entities.Motivo;

@Stateless
public class MotivoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public MotivoDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<Motivo> listar(){

		try {
			Query query = this.entityManager.createQuery("FROM Motivo m");
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<Motivo>();
		}

	}
	
	public Motivo buscarPorNome(Motivo m){
		
		try {
			Query query = this.entityManager.createQuery("FROM Motivo m WHERE m.nome =:param1");
			query.setParameter("param1", m.getNome());
			return (Motivo) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void cadastrar(Motivo m) {
		this.entityManager.persist(m);
	}

}
