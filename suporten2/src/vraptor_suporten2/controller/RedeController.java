package vraptor_suporten2.controller;

import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
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
	public void create() {

	}
	
	@Admin
	@Path("/rede/edit/{id}")
	public Rede edit(Integer id) {		
		
		Rede r = new Rede();
		r.setId(id);
		
		Rede rede = dao.buscarPorId(r);
		
		if(rede == null){
			result.include("mensagemFalha", r.getClass().getSimpleName() + " inexistente!");
		}
		
		return rede;
	}
	
	@Admin
	@Path("/rede/delete/{id}")
	public Rede delete(Integer id) {		
		
		Rede r = new Rede();
		r.setId(id);
		
		Rede rede = dao.buscarPorId(r);
		
		if(rede == null){
			result.include("mensagemFalha", r.getClass().getSimpleName() + " inexistente!");
		}
		
		return rede;
	}	
	

	@Get
	@Path("/rede")
	public List<Rede> list() {
		return dao.listar();
	}

	@Admin
	public void add(@Valid Rede r) {

		validation.onErrorForwardTo(this).create();

		try {

			if(dao.buscarPorNome(r) == null){
				dao.cadastrar(r);
				result.include("mensagem", r.getClass().getSimpleName() + " adicionada com sucesso!");
				result.use(Results.logic()).redirectTo(RedeController.class).list();
			}else{
				result.include("mensagemFalha", r.getClass().getSimpleName() + ": " + r.getNome() + " j� existente!");
				result.forwardTo(this).create();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Admin
	public void update(@Valid Rede r) {

		validation.onErrorForwardTo(this).edit(r.getId());

		try {

			if(dao.buscarPorId(r) != null){
				
				dao.editar(r);
				result.include("mensagem", r.getClass().getSimpleName() + " alterada com sucesso!");
				result.use(Results.logic()).redirectTo(RedeController.class).list();
				
			}else{
				result.include("mensagemFalha", r.getClass().getSimpleName() + " t� de brincation with mi cara!");
				result.use(Results.logic()).redirectTo(RedeController.class).edit(r.getId());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
