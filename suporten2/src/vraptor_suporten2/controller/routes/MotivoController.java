package vraptor_suporten2.controller.routes;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import br.com.caelum.vraptor.Controller;
import vraptor_suporten2.dal.MotivoDAO;

@Controller
@RequestScoped
public class MotivoController extends AbstractCrudController implements EntityCrudControllerInterface{

	@Inject
	private MotivoDAO dao;

	public MotivoController() {

	}

	@Override
	public void create() {
		result.include("macroMotivoList", dao.listar());
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}
	

}
