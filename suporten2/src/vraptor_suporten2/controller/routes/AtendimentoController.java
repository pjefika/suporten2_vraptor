package vraptor_suporten2.controller.routes;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.AtendimentoDAO;
import vraptor_suporten2.model.annotation.Admin;
import vraptor_suporten2.model.annotation.Logado;
import vraptor_suporten2.model.entities.Atendimento;

@Controller
@RequestScoped
public class AtendimentoController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Inject
	private AtendimentoDAO dao;

	public AtendimentoController() {

	}


	@Admin
	public List<Atendimento> list() {
		return dao.listar();
	}
	
	@Logado
	@Path("/atendimento/")
	public void create() {

	}

	@Logado
	public void add(@Valid Atendimento a) {

		validation.onErrorForwardTo(this).create();

		try {
			dao.cadastrar(a);
			result.include("mensagem", a.getClass().getSimpleName() + " cadastrado com sucesso!");
			result.use(Results.logic()).redirectTo(AtendimentoController.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
