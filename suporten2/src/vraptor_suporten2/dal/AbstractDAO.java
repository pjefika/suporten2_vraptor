package vraptor_suporten2.dal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import vraptor_suporten2.model.EntityCrudInterface;
import vraptor_suporten2.model.MacroMotivo;

@Stateless
public class AbstractDAO {

	@PersistenceContext
	protected EntityManager entityManager;

	public void cadastrar(Object param1) {
		this.entityManager.persist(param1);
	}

	public void editar(Object param1){
		this.entityManager.merge(param1);
	}

	public void excluir(Object param1){
		this.entityManager.remove(this.entityManager.merge(param1));
	}
	
	public EntityCrudInterface buscarPorId(EntityCrudInterface ob){
		
		try {
			Query query = this.entityManager.createQuery("FROM " + ob.getClass().getSimpleName() + " m WHERE m.id =:param1");
			query.setParameter("param1", ob.getId());
			return (EntityCrudInterface) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public EntityCrudInterface buscarPorNome(EntityCrudInterface ob){
		
		try {
			Query query = this.entityManager.createQuery("FROM " + ob.getClass().getSimpleName() + " m WHERE m.nome =:param1");
			query.setParameter("param1", ob.getNome());
			return (EntityCrudInterface) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
