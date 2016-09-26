package vraptor_suporten2.controller;

import java.rmi.RemoteException;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import vraptor_suporten2.controller.user.SessionUsuarioEfika;
import webservices.EfikaUsersProxy;
import webservices.Usuario;

@Controller
@RequestScoped
public class UsuarioController {

    @Inject
    private Result result;
    
    private EfikaUsersProxy ws;
    
    private SessionUsuarioEfika session;

	public UsuarioController() {
		ws = new EfikaUsersProxy();
	}
	
	public void form(){
	}

	public void login(@Valid Usuario u){
		
		try {
			
			if(ws.autenticarUsuario(u.getLogin(), u.getSenha())){
				
				session = new SessionUsuarioEfika(u);
				result.include("mensagemFalha", "Login!" + session.getUsuario().getLogin() + " " + session.getUsuario().getNivel());
				result.forwardTo(this).form();
				
			}else{
				
				result.include("mensagemFalha", "Credênciais incorrentas.");
				result.forwardTo(this).form();
			}
			
		} catch (RemoteException e) {
			result.include("mensagemFalha", e.getMessage());
			result.forwardTo(this).form();
		}
	}
	
	public void restrito() {
		result.include("mensagem", "Acesso restrito!");
	}
	
	
}
