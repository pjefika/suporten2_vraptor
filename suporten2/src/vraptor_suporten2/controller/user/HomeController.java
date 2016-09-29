package vraptor_suporten2.controller.user;

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
public class HomeController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	public HomeController() {

	}
	
}
