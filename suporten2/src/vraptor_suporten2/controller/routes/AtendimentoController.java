package vraptor_suporten2.controller.routes;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.controller.auth.SessionUsuarioEfika;
import vraptor_suporten2.dal.AtendimentoDAO;
import vraptor_suporten2.dal.RedeDAO;
import vraptor_suporten2.model.annotation.Admin;
import vraptor_suporten2.model.annotation.Logado;
import vraptor_suporten2.model.entities.Atendimento;

@Controller
@RequestScoped
public class AtendimentoController  extends AbstractCrudController{

	@Inject
	private AtendimentoDAO dao;
	
	@Inject
	private RedeDAO redeDao;
	
	@Inject
    private SessionUsuarioEfika session;
	
	public AtendimentoController() {

	}


	@Admin
	public List<Atendimento> list() {
		return dao.listar();
	}
	
	@Logado
	@Path("/atendimento/")
	public void create() {
		result.include("redeList", redeDao.listar());
	}

	@Logado
	public void add(Atendimento a) {
		
		a.setLoginRegistro(session.getUsuario().getLogin());
		
		if(a.getSolucao().getId() == null){
			validation.add(new SimpleMessage("a.solucao.id", "Campo requerido!"));
		}
		
		validation.onErrorForwardTo(this).create();
		
		try {
			dao.cadastrar(a);
			result.include("mensagem", a.getClass().getSimpleName() + " cadastrado com sucesso!");
			result.use(Results.logic()).redirectTo(AtendimentoController.class).create();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result.include("mensagemFalha", a.getClass().getSimpleName() + " cadastrado com sucesso!");
			result.use(Results.logic()).forwardTo(AtendimentoController.class).create();
		}
	}


	
	
	
}
