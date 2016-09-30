package vraptor_suporten2.dal;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

import vraptor_suporten2.model.MacroMotivo;

@Stateless
public class MacroMotivoDAO extends AbstractDAO{

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
	
	public MacroMotivo buscarPorId(MacroMotivo m){
		
		try {
			Query query = this.entityManager.createQuery("FROM MacroMotivo m WHERE m.id =:param1");
			query.setParameter("param1", m.getId());
			return (MacroMotivo) query.getSingleResult();
		} catch (Exception e) {
			return null;
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
	
	public void excluir(MacroMotivo m) throws Exception{
		
		/**
		 * Validação de Quebra de Constraint
		 */
		if(buscarPorId(m).getMotivos().size() == 0){
			super.excluir(m);
		}else{
			throw new Exception("Falha ao excluir Macro Motivo, existem Motivos associados.");
		}

	}
}
