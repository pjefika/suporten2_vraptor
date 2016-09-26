package vraptor_suporten2.controller;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import webservices.Usuario;

@Controller
@RequestScoped
public class UsuarioController {

    @Inject
    private Result result;

	public UsuarioController() {

	}
	
	public void form(){
	}

	public void login(@Valid Usuario u){
		
	}
	
	public void restrito() {
		result.include("mensagem", "Acesso restrito!");
	}
	
	
}
