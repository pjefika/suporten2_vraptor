package vraptor_suporten2.controller;


import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
@RequestScoped
public class HomeController {

	@Inject
	private Result result;

	@Inject
	private Validator validation;

	public HomeController() {

	}
	
	@Path("/")
	public void index(){
		
	}
	
}
