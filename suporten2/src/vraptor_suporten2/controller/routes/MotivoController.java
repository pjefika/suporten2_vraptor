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
import vraptor_suporten2.model.entities.MacroMotivo;
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

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
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
	public void add(@Valid Motivo m) {
		
		if(m.getMacroMotivo().getId() == null){
			validation.add(new SimpleMessage("m.macromotivo.id", "Campo requerido!"));
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
				result.include("mensagemFalha", m.getClass().getSimpleName() + ": " + m.getNome() + " já existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
