package vraptor_suporten2.controller;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.RedeDAO;
import vraptor_suporten2.model.Rede;
import vraptor_suporten2.model.annotation.Admin;

@Controller
@RequestScoped
public class RedeController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Inject
	private RedeDAO dao;

	public RedeController() {

	}

	@Admin
	public void form() {

	}

	@Admin
	public List<Rede> lista() {
		return dao.listar();
	}

	@Admin
	public void add(@Valid Rede r) {

		validation.onErrorForwardTo(this).form();

		try {

			if(dao.buscarRedePorNome(r) == null){
				dao.cadastrar(r);
				result.include("mensagem", r.getClass().getSimpleName() + " adicionada com sucesso!");
				result.use(Results.logic()).redirectTo(RedeController.class).lista();
			}else{
				result.include("mensagemFalha", r.getClass().getSimpleName() + ": " + r.getNome() + " já existente!");
				result.forwardTo(this).form();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
