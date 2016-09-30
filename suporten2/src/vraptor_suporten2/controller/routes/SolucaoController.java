package vraptor_suporten2.controller.routes;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.SolucaoDAO;
import vraptor_suporten2.model.annotation.Admin;
import vraptor_suporten2.model.entities.Solucao;

@Controller
@RequestScoped
public class SolucaoController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Inject
	private SolucaoDAO dao;

	public SolucaoController() {

	}

	@Admin
	public void create() {

	}

	@Admin
	public List<Solucao> list() {
		return dao.listar();
	}

	@Admin
	public void add(@Valid Solucao s) {

		validation.onErrorForwardTo(this).create();

		try {

			if(dao.buscarPorNome(s) == null){
				dao.cadastrar(s);
				result.include("mensagem", s.getClass().getSimpleName() + " adicionado com sucesso!");
				result.use(Results.logic()).redirectTo(SolucaoController.class).list();
			}else{
				result.include("mensagemFalha", s.getClass().getSimpleName() + ": " + s.getNome() + " já existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
