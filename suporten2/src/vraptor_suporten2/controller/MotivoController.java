package vraptor_suporten2.controller;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.MotivoDAO;
import vraptor_suporten2.model.Motivo;
import vraptor_suporten2.model.annotation.Admin;

@Controller
@RequestScoped
public class MotivoController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Inject
	private MotivoDAO dao;

	public MotivoController() {

	}

	@Admin
	public void create() {

	}

	@Admin
	public List<Motivo> list() {
		return dao.listar();
	}

	@Admin
	public void add(@Valid Motivo m) {

		validation.onErrorForwardTo(this).create();

		try {

			if(dao.buscarPorNome(m) == null){
				dao.cadastrar(m);
				result.include("mensagem", m.getClass().getSimpleName() + " adicionado com sucesso!");
				result.use(Results.logic()).redirectTo(MotivoController.class).list();
			}else{
				result.include("mensagemFalha", m.getClass().getSimpleName() + ": " + m.getNome() + " já existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
