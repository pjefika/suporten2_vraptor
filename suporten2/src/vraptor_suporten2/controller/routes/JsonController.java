package vraptor_suporten2.controller.routes;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.RedeDAO;
import vraptor_suporten2.model.entities.Rede;

@Controller
@RequestScoped
public class JsonController extends AbstractCrudController{
	
	@Inject
	private RedeDAO dao;

	public JsonController() {
	}
	
	@Path("/json/macromotivos/{id}")
    public void loadJson(Integer id) {
		Rede r = (Rede) dao.buscarPorId(new Rede(id));
		result.use(Results.json()).from(r.getMacroMotivos()).serialize();
    }
}
