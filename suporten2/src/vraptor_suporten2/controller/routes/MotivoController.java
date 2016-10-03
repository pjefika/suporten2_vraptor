package vraptor_suporten2.controller.routes;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.MacroMotivoDAO;
import vraptor_suporten2.dal.MotivoDAO;
import vraptor_suporten2.model.annotation.Admin;
import vraptor_suporten2.model.entities.Motivo;

@Controller
@RequestScoped
public class MotivoController extends AbstractCrudController implements EntityCrudControllerInterface{

	@Inject
	private MotivoDAO dao;
	
	@Inject
	private MacroMotivoDAO macroDao;

	public MotivoController() {

	}

	@Override
	public void create() {
		result.include("macroMotivoList", macroDao.listar());
		
	}
	
	@Admin
	public void add(@Valid Motivo m) {
		
		if(m.getMacroMotivo().getId() == null){
			validation.add(new SimpleMessage("m.macroMotivo.id", "Campo requerido!"));
		}
		
		validation.onErrorForwardTo(this).create();

		try {
			
			if((Motivo) dao.buscarPorNome(m) == null){
				
				if(m.getAtivo() == null){
					m.setAtivo(false);
				}
				
				dao.cadastrar(m);
				result.include("mensagem", m.getClass().getSimpleName() + " adicionado com sucesso!");
				result.use(Results.logic()).redirectTo(this.getClass()).list();
				
			}else{
				result.include("mensagemFalha", m.getClass().getSimpleName() + ": " + m.getNome() + " j� existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	@Override
	@Admin
	public void delete(Integer id) {
		
		Motivo m = new Motivo();
		m.setId(id);
		Motivo macro = (Motivo) dao.buscarPorId(m);
		
		if(macro != null){
			
			try {
				dao.excluir(macro);
				result.use(Results.logic()).redirectTo(this.getClass()).list();
			} catch (Exception e) {
				result.include("mensagemFalha", e.getMessage());
			}
			
		}else{
			result.include("mensagemFalha", m.getClass().getSimpleName() + " inexistente!");
		}
		
	}

	@Path("/motivo")
	@Admin
	public List<Motivo> list() {
		return dao.listar();
	}
	
	@Admin
	@Path("/motivo/edit/{id}")
	public Motivo edit(Integer id) {		
		
		Motivo m = new Motivo();
		m.setId(id);
		
		Motivo macro = (Motivo) dao.buscarPorId(m);
		
		result.include("macroMotivoList", macroDao.listar());
		
		if(macro == null){
			result.include("mensagemFalha", m.getClass().getSimpleName() + " inexistente!");
		}
	
		return macro;
	}

	
	@Admin
	public void update(@Valid Motivo m) {

		if(m.getMacroMotivo().getId() == null){
			validation.add(new SimpleMessage("m.macroMotivo.id", "Campo requerido!"));
		}
		
		validation.onErrorForwardTo(this).create();
		
		Motivo md = (Motivo) dao.buscarPorId(m);

		try {

			if(md != null && md.getId() == m.getId()){
				
				dao.editar(m);
				result.include("mensagem", "Altera��es realizadas com sucesso!");
				result.use(Results.logic()).redirectTo(this.getClass()).list();
				
			}else{
				
				result.include("mensagemFalha", "Falha ao alterar " + m.getClass().getSimpleName() + ".");
				result.use(Results.logic()).forwardTo(this.getClass()).edit(m.getId());
				
			}
				
		} catch (Exception e) {
			result.include("mensagemFalha", "Falha ao alterar " + m.getClass().getSimpleName() + ".");
			result.use(Results.logic()).forwardTo(this.getClass()).edit(m.getId());
		}
	}	


}
