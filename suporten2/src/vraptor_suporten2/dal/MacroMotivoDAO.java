package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vraptor_suporten2.model.MacroMotivo;

@Stateless
public class MacroMotivoDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public MacroMotivoDAO() {

	}

	@SuppressWarnings("unchecked")
	public List<MacroMotivo> listar(){

		try {
			Query query = this.entityManager.createQuery("FROM MacroMotivo m");
			return query.getResultList();
		} catch (Exception e) {
			return new ArrayList<MacroMotivo>();
		}

	}
	
	public MacroMotivo buscarPorNome(MacroMotivo m){
		
		try {
			Query query = this.entityManager.createQuery("FROM MacroMotivo m WHERE m.nome =:param1");
			query.setParameter("param1", m.getNome());
			return (MacroMotivo) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	public void cadastrar(MacroMotivo m) {
		this.entityManager.persist(m);
	}

}
