package vraptor_suporten2.controller;

import java.rmi.RemoteException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import vraptor_suporten2.controller.user.SessionUsuarioEfika;
import webservices.EfikaUsersProxy;
import webservices.Usuario;

@Controller
@RequestScoped
@Named
public class UsuarioController {

    @Inject
    private Result result;
    
    private EfikaUsersProxy ws;
    
    @Inject
    private SessionUsuarioEfika session;
	
    public UsuarioController() {

    }
    
    public UsuarioController(Result result) {
    	this.result = result;
    }    
    
	public void create(){
	}
	
	public void detail(){
		result.include("usuario", session.getUsuario());
	}
	
	public void login(Usuario u){
		
		try {
			
			ws = new EfikaUsersProxy();
			
			if(ws.autenticarUsuario(u.getLogin(), u.getSenha())){
				
				u = ws.consultarUsuario(u.getLogin());
				session.setUsuario(u);
				
				result.include("mensagemFalha", "Login!" + session.getUsuario().getLogin() + " " + session.getUsuario().getNivel());
				result.forwardTo(this).create();
				
			}else{
				
				result.include("mensagemFalha", "Credênciais incorrentas.");
				result.forwardTo(this).create();
			}
			
		} catch (RemoteException e) {
			
			result.include("mensagemFalha", e.getMessage());
			result.forwardTo(this).create();
		}
	}
	
	public void restrito() {
		result.include("mensagem", "Acesso restrito!");
	}
	
	
}
