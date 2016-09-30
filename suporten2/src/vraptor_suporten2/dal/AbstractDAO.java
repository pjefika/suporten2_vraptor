package vraptor_suporten2.dal;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
