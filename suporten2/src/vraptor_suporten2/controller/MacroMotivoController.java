package vraptor_suporten2.controller;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import vraptor_suporten2.dal.MacroMotivoDAO;
import vraptor_suporten2.dal.RedeDAO;
import vraptor_suporten2.model.MacroMotivo;
import vraptor_suporten2.model.Rede;
import vraptor_suporten2.model.annotation.Admin;

@Controller
@RequestScoped
public class MacroMotivoController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	@Inject
	private MacroMotivoDAO dao;
	
	@Inject
	private RedeDAO redeDao;

	public MacroMotivoController() {

	}

	@Admin
	public void create() {
		result.include("redeList", redeDao.listar());
	}

	@Admin
	public List<MacroMotivo> list() {
		return dao.listar();
	}

	@Admin
	public void add(@Valid MacroMotivo m) {

		validation.onErrorForwardTo(this).create();

		try {

			if(dao.buscarPorNome(m) == null){
				dao.cadastrar(m);
				result.include("mensagem", m.getClass().getSimpleName() + " adicionado com sucesso!");
				result.use(Results.logic()).redirectTo(MacroMotivoController.class).list();
			}else{
				result.include("mensagemFalha", m.getClass().getSimpleName() + ": " + m.getNome() + " já existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
