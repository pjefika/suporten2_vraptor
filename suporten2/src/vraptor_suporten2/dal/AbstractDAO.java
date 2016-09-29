package vraptor_suporten2.dal;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.RollbackException;

public class AbstractDAO {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	public void cadastrar(Object param1) {
		this.entityManager.persist(param1);
	}
	
	public void editar(Object param1){
		this.entityManager.merge(param1);
	}

	public void excluir(Object param1) throws Exception {

		try {
			this.entityManager.remove(this.entityManager.merge(param1));
		} catch (RollbackException e) {
			throw new Exception("Erro ao excluir " + param1.getClass().getSimpleName() + "!");
		}
	}
	
}
