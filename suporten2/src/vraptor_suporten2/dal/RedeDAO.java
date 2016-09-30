package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import vraptor_suporten2.model.Rede;

@Stateless
public class RedeDAO extends AbstractDAO{

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
	
	public Rede buscarPorNome(Rede r){
		
		try {
			Query query = this.entityManager.createQuery("FROM Rede r WHERE r.nome =:param1");
			query.setParameter("param1", r.getNome());
			return (Rede) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public Rede buscarPorId(Rede r){
		
		try {
			Query query = this.entityManager.createQuery("FROM Rede r WHERE r.id =:param1");
			query.setParameter("param1", r.getId());
			return (Rede) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public void excluir(Rede r) throws Exception{
		
		/**
		 * Validação de Quebra de Constraint
		 */
		if(buscarPorId(r).getMacroMotivos().size() == 0){
			super.excluir(r);
		}else{
			throw new Exception("Falha ao excluir Rede, existem Macro Motivos associados.");
		}

	}
	
}
